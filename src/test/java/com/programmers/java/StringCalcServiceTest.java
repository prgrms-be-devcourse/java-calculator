package com.programmers.java;


import com.programmers.java.engine.model.ValidFormula;
import com.programmers.java.engine.repository.FormulaRepo;
import com.programmers.java.engine.service.CalcService;
import com.programmers.java.engine.service.PostFixService;
import com.programmers.java.engine.service.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalcServiceTest {

    String str = "1 + 2 * 3 + 2 / 1";
    ValidationService validService = new ValidationService();
    PostFixService postFixService = new PostFixService();
    ValidFormula validFormula = new ValidFormula(str.split(" "));
    CalcService c = new CalcService();

    @Test
    public void 입력식_유효성테스트() {
        Assertions.assertArrayEquals(validFormula.getFormula(), validService.Validation(str).get().getFormula());
    }

    @Test
    public void 후위표기법_변환_테스트() {
        String postFix = "1 2 3 * 2 1 / ^ + +";
        Assertions.assertArrayEquals(postFix.split(" "), postFixService.makePostFixFormula(validService.Validation(str).get()));
    }

    @Test
    public void 후위표기법_수식계산_테스트() {
        Assertions.assertEquals(9, c.calculate(postFixService.makePostFixFormula(validService.Validation(str).get())));
    }

    FormulaRepo formulaRepo = new FormulaRepo();
    @Test
    public void 조회Map_save_테스트() {
        formulaRepo.save("1 + 2", 3L);
        formulaRepo.save("1 + 3", 4L);
        formulaRepo.save("1 + 4", 5L);
        Assertions.assertNotNull(formulaRepo.getHistory());
    }

    @Test
    public void 조회Map_size_테스트() {
        formulaRepo.save("1 + 2", 3L);
        formulaRepo.save("1 + 3", 4L);
        formulaRepo.save("1 + 4", 5L);
        Assertions.assertEquals(3, formulaRepo.size());
    }
}
