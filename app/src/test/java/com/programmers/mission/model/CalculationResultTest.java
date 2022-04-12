package com.programmers.mission.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculationResultTest {

	@Test
	@DisplayName("계산기 핵심 로직 테스트")
	public void calculate() {
		//given
		String inputExpression = "1 + 2 * 3";
		String expectedAnswer = inputExpression + "\n7";

		//when
		CalculationResult calculationResult = new CalculationResult(inputExpression);

		//then
		Assertions.assertEquals(calculationResult.toString(), expectedAnswer);
	}

	@Test
	@DisplayName("계산기 핵심 로직 테스트")
	public void calculate2() {
		//given
		String inputExpression = "1 * 2 * 3";
		String expectedAnswer = inputExpression + "\n6";

		//when
		CalculationResult calculationResult = new CalculationResult(inputExpression);

		//then
		Assertions.assertEquals(calculationResult.toString(), expectedAnswer);
	}

}