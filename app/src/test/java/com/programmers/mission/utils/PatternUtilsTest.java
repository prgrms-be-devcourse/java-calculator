package com.programmers.mission.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;

class PatternUtilsTest {
	private List<String> numberDatas;
	private List<String> notNumberDatas;

	@BeforeEach
	public void init() {

		Faker faker = new Faker();

		this.numberDatas = Stream.generate(() -> faker.number().numberBetween(0, 1000))
				.distinct()
				.limit(10)
				.map(String::valueOf)
				.toList();

		this.notNumberDatas = Stream.generate(() -> {
					int number = faker.number().numberBetween(0, 100);
					String username = faker.name().username();

					return username + String.valueOf(number);
				})
				.limit(10)
				.toList();

	}

	@DisplayName("success : 숫자로만 이루어져 있는지 확인하는 테스트 성공 코드")
	@Test
	void isNumeric() {
		numberDatas.stream()
				.forEach(value -> {
					// when
					boolean numeric = PatternUtils.isNumeric(value);
					// then
					Assertions.assertTrue(numeric);
				});
	}

	@DisplayName("false : 숫자로만 이루어져 있는지 확인하는 테스트")
	@Test
	void isNumericFalse() {

		notNumberDatas.stream()
				.forEach(value -> {
					// when
					boolean numeric = PatternUtils.isNumeric(value);
					// then
					Assertions.assertFalse(numeric);
				});
	}

	@DisplayName("success : 연산자로 이루어져 있는지 확인하는 테스트 코드")
	@Test
	void isOperator() {

		List<String> notOperators = this.notNumberDatas;

		notOperators.stream()
				.forEach(value -> {
					//when
					boolean operator = PatternUtils.isOperator(value);
					// then
					Assertions.assertFalse(operator);
				});
	}

}