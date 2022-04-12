package com.programmers.mission.validation;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

class CalculatorValidationTest {

	private Faker faker;
	private InputValidation validation;

	@BeforeEach
	public void init() {
		faker = new Faker();
		validation = new CalculatorValidation();
	}

	@DisplayName("계산식 유효성 검증 성공 코드")
	@Test
	void isProperExpression() {
		// given
		String expression= "1 + 2 * 3";

		// when
		boolean properExpression = validation.isProperExpression(expression);

		// then
		Assertions.assertTrue(properExpression);
	}

	@DisplayName("계산식 유효성 검증 실패 코드")
	@Test
	void isProperExpressionFalse() {
		// given
		String nonSpacingExpression= "1 +2 * 3";
		String bracketExpression= "(1 + 2) * 3";
		String notProperExpression1= "-1 + 2 * 3+";
		String notProperExpression2= "+1 + 2 * 3";

		List<String> nonProperExpression = List.of(nonSpacingExpression, bracketExpression, notProperExpression1, notProperExpression2);

		// when
		nonProperExpression
				.forEach(value -> {
					boolean properExpression = validation.isProperExpression(value);
					// then
					Assertions.assertFalse(properExpression);
				});
	}

	@DisplayName("계산기 프로그램에서 제공하는 서비스 타입으로 이루어져 있는지 판단하는 성공 테스트 코드")
	@Test
	void isMatchServiceTypeSuccess() {
		// given
		List<String> clientInputs = Stream.generate(() -> String.valueOf(faker.number().numberBetween(1, 2)))
				.limit(5).toList();

		// when
		clientInputs.stream().forEach(clientInputMenu -> {
			// then
			Assertions.assertTrue(validation.isMatchServiceType(clientInputMenu));
		});
	}

	@DisplayName("계산기 프로그램에서 제공하는 서비스 타입으로 이루어져 있는지 판단하는 실패 테스트 코드")
	@Test
	void isMatchServiceTypeFalse() {
		// given
		List<String> clientInputs = Stream.generate(() -> String.valueOf(faker.number().numberBetween(3, 100)))
				.limit(5).toList();

		// when
		clientInputs.stream().forEach(clientInputMenu -> {
			// then
			Assertions.assertFalse(validation.isMatchServiceType(clientInputMenu));
		});
	}


}