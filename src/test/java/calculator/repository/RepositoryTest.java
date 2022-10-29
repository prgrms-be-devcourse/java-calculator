package calculator.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import calculator.operation.PostfixOperation;
import calculator.validator.FormulaValidator;

class RepositoryTest {

	ResultRepository repository = new ResultRepository();
	PostfixOperation postfixOperation = new PostfixOperation(new FormulaValidator());

	@Test
	@DisplayName("연산결과 저장")
	void test1() {

		//given
		String formula = "3+2*4-1";
		List<String> origin = Arrays.asList("3", "+", "2", "*", "4", "-", "1");
		String result = postfixOperation.calculate(origin);

		//when
		repository.save(new FormulaResult(formula, result));
		String saved = repository.findOne(formula).get().getAnswer();

		//then
		Assertions.assertEquals(saved, result);

	}

	@Test
	@DisplayName("전체 조회")
	void test2() {

		//given
		String formula1 = "3+2*4-1";
		List<String> origin1 = Arrays.asList("3", "+", "2", "*", "4", "-", "1");
		String result1 = postfixOperation.calculate(origin1);

		String formula2 = "3-2*4+1";
		List<String> origin2 = Arrays.asList("3", "-", "2", "*", "4", "+", "1");
		String result2 = postfixOperation.calculate(origin2);

		List<String> expect = Arrays.asList("3+2*4-1 = 10.0", "3-2*4+1 = -6.0");

		//when
		repository.save(new FormulaResult(formula1, result1));
		repository.save(new FormulaResult(formula2, result2));
		List<FormulaResult> saved = repository.findAll();
		List<String> savedString = saved.stream().map(FormulaResult::toString).collect(Collectors.toList());
		//then
		Assertions.assertEquals(expect, savedString);

	}

}

