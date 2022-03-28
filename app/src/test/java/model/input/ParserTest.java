package model.input;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParserTest {

	private Parser parser;
	private String validTarget;

	@BeforeEach
	public void setUp() {
		validTarget = "1 + 2 * 3 - 1";
		parser = new ParserWithBlank();

	}

	@Test
	public void 주어진문자열타겟을_파싱하여_문자열_배열을_생성() {
		String[] expected = new String[]{"1", "+", "2", "*", "3", "-", "1"};

		Assertions.assertTrue(
			Arrays.equals(expected, parser.parse(validTarget))
		);
	}

}
