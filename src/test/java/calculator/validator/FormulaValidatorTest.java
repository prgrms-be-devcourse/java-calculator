package calculator.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FormulaValidatorTest {

	FormulaValidator formulaValidator = new FormulaValidator();

	@Test
	@DisplayName("숫자 검증 성공")
	void test1() {

		//given
		String origin = "1234";

		//expect
		Assertions.assertTrue(formulaValidator.isNumber(origin));

	}

	@Test
	@DisplayName("숫자 검증 실패")
	void test2() {

		//given
		String origin = "123+";

		//expect
		Assertions.assertFalse(formulaValidator.isNumber(origin));

	}

	@Test
	@DisplayName("식 검증 성공")
	void test3() {

		//given
		String origin1 = "1+2+3";
		String origin2 = "1+22*3/2";
		String origin3 = "111+222-33";

		Assertions.assertTrue(formulaValidator.isFormula(origin1));
		Assertions.assertTrue(formulaValidator.isFormula(origin2));
		Assertions.assertTrue(formulaValidator.isFormula(origin3));
	}

	@Test
	@DisplayName("식 검증 실패")
	void test4() {

		//given
		String origin1 = "+1+2+3";
		String origin2 = "1+22**3/2";
		String origin3 = "111+222-33-";

		Assertions.assertFalse(formulaValidator.isFormula(origin1));
		Assertions.assertFalse(formulaValidator.isFormula(origin2));
		Assertions.assertFalse(formulaValidator.isFormula(origin3));

	}
}