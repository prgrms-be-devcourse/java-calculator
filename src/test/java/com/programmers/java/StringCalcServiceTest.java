package com.programmers.java;


import com.programmers.java.engine.model.Formula;
import com.programmers.java.engine.repository.FormulaRepository;
import com.programmers.java.engine.service.CalcService;
import com.programmers.java.engine.service.PostFixService;
import com.programmers.java.engine.service.ValidationService;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class StringCalcServiceTest {
    static final String TESTFORMULA1 = "1 + 2 * 3";
    static final String TESTFORMULA2 = "-1 + 3 * -2";
    static final String TESTFORMULA3 = "2 - 7 * 3 + 5 - 3";
    static final Long TESTRESULT1 = 7L;
    static final Long TESTRESULT2 = -7L;
    static final Long TESTRESULT3 = -17L;

    ValidationService testValidationService = new ValidationService();
    PostFixService testPostFixService = new PostFixService();
    CalcService testCalc = new CalcService();


    @Test
    public void ValidationService_Validation함수_유효한식_NotNull옵셔널_반환() {
        //given
        String testFormula2 = "1+ ";
        //when
        Optional<Formula> correctFormula = testValidationService.Validation(TESTFORMULA1);
        Optional<Formula> incorrectFormula = testValidationService.Validation(testFormula2);
        //then
        Assertions.assertNotNull(correctFormula);
        Assertions.assertTrue(incorrectFormula.isEmpty());
    }

    @Test
    public void PostFixService_makePostFixFormula함수_후위표기식_반환() {
        //given
        String postFix = "1 2 3 * +";
        //when
        String[] postFixTestForm = testPostFixService.makePostFixFormula(testValidationService.Validation(TESTFORMULA1).get());
        //then
        Assertions.assertArrayEquals(postFix.split(" "), postFixTestForm);
    }

    @Test
    public void PostFixService_OperatorPriority함수_연산자우선순위_반환() {
        //given
        int MULDIV = 1;
        int PLUSMINUS = 2;
        //when
        int plus = testPostFixService.OperatorPriority("+");
        int minus = testPostFixService.OperatorPriority("+");
        int mul = testPostFixService.OperatorPriority("+");
        int div = testPostFixService.OperatorPriority("+");
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
        Long plus = testCalc.calcArithmetic(a, b, "+", s).pop();
        Long minus = testCalc.calcArithmetic(a, b, "-", s).pop();
        Long mul = testCalc.calcArithmetic(a, b, "*", s).pop();
        Long div = testCalc.calcArithmetic(a, b, "/", s).pop();
        //then
        Assertions.assertEquals(3, plus);
        Assertions.assertEquals(-1, minus);
        Assertions.assertEquals(2, mul);
        Assertions.assertEquals(0, div);
    }

    @Test
    public void CalcService_calculate함수_계산결과_반환() {
        //given
        String postFixFormula[] = testPostFixService.makePostFixFormula(testValidationService.Validation(TESTFORMULA1).get());
        //when
        Long testResult = testCalc.calculate(postFixFormula);
        //then
        Assertions.assertEquals(TESTRESULT1, testResult);
    }

    private static FormulaRepository testRepository = new FormulaRepository();

    @Test
    @BeforeAll
    public static void FormulaRepository_save함수_map사이즈_반환() {
        //given
        testRepository.save(TESTFORMULA1, TESTRESULT1);
        testRepository.save(TESTFORMULA2, TESTRESULT2);
        testRepository.save(TESTFORMULA3, TESTRESULT3);
        //when
        Map<String, Long> testMap = testRepository.getHistory();
        //then
        Assertions.assertEquals(3, testMap.size());
    }

    @Test
    public void FormulaRepository_size함수_map사이즈_반환() {
        //given

        //when
        int size = testRepository.size();
        //then
        Assertions.assertEquals(3, size);
    }

    @Test
    public void FormulaRepository_find함수_계산이력_반환() {
        //given
        String resultOuput[] = new String[3];
        resultOuput[0] = TESTFORMULA1 + " = " + TESTRESULT1;
        resultOuput[1] = TESTFORMULA2 + " = " + TESTRESULT2;
        resultOuput[2] = TESTFORMULA3 + " = " + TESTRESULT3;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //WHEN
        testRepository.findAll();
        String testOutput[] = out.toString().split("\n");

        //then
        for (int i = 0; i < resultOuput.length; i++) {
            Assertions.assertEquals(resultOuput[i],testOutput[i].trim());
        }
    }
}


