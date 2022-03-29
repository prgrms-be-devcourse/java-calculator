package com.programmers.java;


import com.programmers.java.engine.model.Formula;
import com.programmers.java.engine.repository.FormulaRepository;
import com.programmers.java.engine.service.CalcService;
import com.programmers.java.engine.service.PostFixService;
import com.programmers.java.engine.service.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StringCalcServiceTest {
    final String TESTFORMULA1 = "1 + 2 * 3";
    final String TESTFORMULA2 = "-1 + 3 * -2";
    final String TESTFORMULA3 = "2 - 7 * 3 + 5 - 3";
    final Long TESTRESULT1 = 7L;
    final Long TESTRESULT2 = -7L;
    final Long TESTRESULT3 = -17L;

    ValidationService validService = new ValidationService();
    PostFixService postFixService = new PostFixService();
    CalcService c = new CalcService();

    @Test
    public void ValidationService_Validation함수_유효한식_NotNull옵셔널_반환() {
        //given
        String testFormula1 = this.TESTFORMULA1;
        String testFormula2 = "1+ ";
        //when
        Optional<Formula> correctFormula =  validService.Validation(testFormula1);
        Optional<Formula> incorrectFormula =  validService.Validation(testFormula2);
        //then
        Assertions.assertTrue(!correctFormula.isEmpty());
        Assertions.assertFalse(!incorrectFormula.isEmpty());
    }

    @Test
    public void PostFixService_makePostFixFormula함수_후위표기식_반환() {
        //given
        String postFix = "1 2 3 * +";
        //when
        String[] postFixTestForm = postFixService.makePostFixFormula(validService.Validation(TESTFORMULA1).get());
        //then
        Assertions.assertArrayEquals(postFix.split(" "), postFixTestForm);
    }

    @Test
    public void PostFixService_OperatorPriority함수_연산자우선순위_반환() {
        //given
        int MULDIV = 1;
        int PLUSMINUS = 2;
        //when
        int plus = postFixService.OperatorPriority("+");
        int minus = postFixService.OperatorPriority("+");
        int mul = postFixService.OperatorPriority("+");
        int div = postFixService.OperatorPriority("+");
        //then
        Assertions.assertEquals(PLUSMINUS, plus, minus);
        Assertions.assertEquals(MULDIV, mul, div);

    }

    @Test
    public void CalcService_calcArithmetic함수_사칙연산계산값_반환() {
        // given
        Long a = 1L;
        Long b = 2L;
        Stack<Long> s = new Stack<>();
        //when
        Long plus = c.calcArithmetic(a,b,"+", s).pop();
        Long minus = c.calcArithmetic(a,b,"-", s).pop();
        Long mul = c.calcArithmetic(a,b,"*", s).pop();
        Long div = c.calcArithmetic(a,b,"/", s).pop();
        //then
        Assertions.assertEquals(3, plus);
        Assertions.assertEquals(-1, minus);
        Assertions.assertEquals(2,mul);
        Assertions.assertEquals(0, div);
    }

    @Test
    public void CalcService_calculate함수_계산결과_반환() {
        //given
        String  postFixFormula[] = postFixService.makePostFixFormula(validService.Validation(TESTFORMULA1).get());
        //when
        Long testResult = c.calculate(postFixFormula);
        //then
        Assertions.assertEquals(TESTRESULT1, testResult);
    }

    FormulaRepository formulaRepository = new FormulaRepository();
    @Test
    public void FormulaRepository_save함수_map사이즈_반환() {
        //given
        formulaRepository.save(TESTFORMULA1, TESTRESULT1);
        formulaRepository.save(TESTFORMULA2, TESTRESULT2);
        formulaRepository.save(TESTFORMULA3, TESTRESULT3);
        //when
        Map<String, Long> testMap = formulaRepository.find();
        //then
        Assertions.assertEquals(3 , testMap.size());
    }

    @Test
    public void FormulaRepository_size함수_map사이즈_반환() {
        //given
        formulaRepository.save(TESTFORMULA1, TESTRESULT1);
        formulaRepository.save(TESTFORMULA2, TESTRESULT2);
        formulaRepository.save(TESTFORMULA3, TESTRESULT3);
        //when
        int size = formulaRepository.size();
        //then
        Assertions.assertEquals(3, size);
    }
}


