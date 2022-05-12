package com.programmers.java.engine.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.programmers.java.engine.model.FormulaAndResult;

public class FormulaRepositoryTest {

	private final String TEST_FORMULA = "1 + 2";
	private final long TEST_RESULT = 3;
	private final FormulaAndResult TEST_FORMULA_RESULT = new FormulaAndResult(TEST_FORMULA, TEST_RESULT);
	private final MemoryFormulaRepository formulaRepository = new MemoryFormulaRepository();

	@Test
	public void 식과_결과가들어오면_testHistory와_history가_같아야함() {
		//given
		//when
		FormulaAndResult savedForm = formulaRepository.save(TEST_FORMULA_RESULT);
		//then
		Assertions.assertEquals(TEST_FORMULA_RESULT, savedForm);
	}

	@Test
	public void history에_저장된_모든값이_출력되어야함() {
		//given
		formulaRepository.save(TEST_FORMULA_RESULT);
		List<FormulaAndResult> history = new ArrayList<>();
		history.add(TEST_FORMULA_RESULT);
		//when
		List<FormulaAndResult> foundHistory = formulaRepository.findAll();
		//then
		Assertions.assertSame(history, foundHistory);
	}

	@Test
	public void history에_저장된_계산이력_크기인_1이_나와야함() {
		//given
		formulaRepository.save(TEST_FORMULA_RESULT);
		int resultSize = 1;
		//when
		int testSize = formulaRepository.size();
		//then
		Assertions.assertEquals(resultSize, testSize);
	}
}
