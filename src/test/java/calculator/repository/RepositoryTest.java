package calculator.repository;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.operation.OperationManager;
import calculator.validator.FormulaValidator;

class RepositoryTest {

	ResultRepository repository = ResultRepository.REPOSITORY;
	OperationManager operationManager = new OperationManager(new FormulaValidator());

	@Test
	@DisplayName("연산결과 저장")
	void test1() {

		//given
		String formula = "3 + 2 * 4 - 1";
		List<String> origin = Arrays.asList("3", "2", "4", "*", "1", "-", "+");
		String result = operationManager.calculate(origin);

		//when
		repository.save(formula, result);
		String saved = repository.find(formula);

		//then
		Assertions.assertEquals(saved, result);

	}

	@Test
	@DisplayName("전체 조회")
	void test2() {

		//given
		String formula1 = "3 + 2 * 4 - 1";
		List<String> origin1 = Arrays.asList("3", "2", "4", "*", "1", "-", "+");
		String result1 = operationManager.calculate(origin1);

		String formula2 = "3 - 2 * 4 + 1";
		List<String> origin2 = Arrays.asList("3", "2", "4", "*", "1", "+", "-");
		String result2 = operationManager.calculate(origin2);

		List<String> expect = Arrays.asList("3 + 2 * 4 - 1 = 10.0", "3 - 2 * 4 + 1 = -6.0");

		//when
		repository.save(formula1, result1);
		repository.save(formula2, result2);
		List<String> saved = repository.findAll();

		//then
		Assertions.assertEquals(expect, saved);

	}

	@Test
	@DisplayName("키값 조회")
	void test3() {

		//given
		String formula = "3 + 2 * 4 - 1";
		List<String> origin = Arrays.asList("3", "2", "4", "*", "1", "-", "+");
		String result = operationManager.calculate(origin);

		//when
		repository.save(formula, result);

		//then
		Assertions.assertTrue(repository.isExist(formula));
	}
}