package calculator.parse;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringParseTest {

	StringParse stringParse = new StringParse();

	@Test
	@DisplayName("문자열 공백 제거")
	void test1() {

		//given
		String origin = "1 + 2  /  3 -4";
		String expect = "1+2/3-4";

		//when
		String parseStr = stringParse.parse(origin);

		//then
		Assertions.assertEquals(expect, parseStr);

	}

	@Test
	@DisplayName("문자열 split")
	void test2() {

		//given
		String origin = "1+2/3-4";
		List<String> expect = Arrays.asList("1", "+", "2", "/", "3", "-", "4");

		//when
		List<String> savedList = stringParse.toList(origin);

		//then
		Assertions.assertEquals(expect, savedList);
	}
}