package com.programmers.devcourse.processor;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringTokenProcessorTest {

	StringTokenProcessor processor = new StringTokenProcessor();

	private static Stream<Arguments> listAnswerProvider() {

		return Stream.of(Arguments.of(Arrays.asList("3.5", "+", "1"), 4.5),
			Arguments.of(Arrays.asList("5.5", "-", "1"), 4.5),
			Arguments.of(Arrays.asList("7.5", "+", "1", "*", "92.5"), 100)
		);

	}

	@DisplayName("process의 결과가 예상한 정답과 일치해야 한다.")
	@ParameterizedTest
	@MethodSource("listAnswerProvider")
	void testProcessReturnProperResult(List<String> expected, double actual) throws Exception {
		assertThat(processor.process(expected)).isEqualTo(actual);
	}

	@DisplayName("process의 return 값이 소수점까지 일치해야 한다.")
	@ParameterizedTest
	@MethodSource("listAnswerProvider")
	void testProcessReturnDifferentResult(List<String> expected, double actual) throws Exception {
		assertThat(processor.process(expected)).isNotEqualTo(Double.sum(actual, 0.0001));
	}

}
