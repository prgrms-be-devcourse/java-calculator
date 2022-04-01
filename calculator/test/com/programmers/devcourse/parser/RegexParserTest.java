package com.programmers.devcourse.parser;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.programmers.devcourse.exception.parser.NotAcceptableStringException;
import com.programmers.devcourse.exception.parser.ParserException;
import com.programmers.devcourse.exception.parser.WrongTokenCountException;
import com.programmers.devcourse.exception.parser.WrongTokenPositionException;

class RegexParserTest {

	Parser parser = new RegexParser();
	List<String> parsedTokenList;
	List<String> compareTarget;

	@DisplayName("문자열에 빈 칸이 없을 때 토큰을 정확하게 구해야 한다.")
	@Test
	void testParserShouldReturnProperTokenArrayWhenTargetStringHasNoSpace() throws ParserException {
		// test 공백 없이 붙여 넣었을 때
		parsedTokenList = parser.parse("1+2*3+4.54234");
		compareTarget =
			List.of("1", "+", "2", "*", "3", "+", "4.54234");
		assertThat(parsedTokenList).isEqualTo(compareTarget);

	}

	@DisplayName("문자열에 빈칸 있을 때 정확하게 토큰을 구해야 한다.")
	@Test
	void testParserShouldReturnProperTokenArrayWhenInputStringHasSpace() throws ParserException {

		// 공백이 존재할 때
		parsedTokenList = parser.parse("5.3 + 4 /6");
		compareTarget = List.of("5.3", "+", "4", "/", "6");
		assertThat(parsedTokenList).isEqualTo(compareTarget);

	}

	@DisplayName("토큰 개수가 연산에 적합하지 않을 때 WrongTokenCountException을 던져야 한다.")
	@ParameterizedTest()
	@ValueSource(strings = {"1+2*", "           "})
	void testParserThrowsExceptionWhenInputStringHasWrongTokenCount(String target) {
		assertThatExceptionOfType(WrongTokenCountException.class).isThrownBy(() -> {
			parser.parse(target);
		});

	}

	@DisplayName("토큰들의 순서가 연산에 적합하지 않을 때 WrongTokenPositionException을 던져야 한다.")
	@ParameterizedTest()
	@ValueSource(strings = {"+45", "5  3 +"})
	void testParserThrowExceptionWhenInputStringHasWrongOrder(String target) {
		assertThatExceptionOfType(WrongTokenPositionException.class).isThrownBy(() -> {
			parser.parse(target);
		});
	}

	@DisplayName("토큰에 적합하지 않은 문자열이 들어왔을 때 NotAcceptableStringException을 던져야 한다.")
	@ParameterizedTest
	@ValueSource(strings = {"        a ", "  asdfkjzxv ", "@#IY@Y&*&Y&*"})
	void testParserThrowNotAcceptableStringExceptionWhenInputStringHasWrongCharacter(String target) {
		assertThatExceptionOfType(NotAcceptableStringException.class).isThrownBy(() -> {
			parser.parse(target);
		});
	}

}
