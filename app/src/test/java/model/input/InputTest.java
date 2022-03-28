package model.input;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputTest {

	private Parser blankParser;

	@BeforeEach
	public void setUp() {
		blankParser = new ParserWithBlank();
	}

	/**
	 * 1. 입력 문자열에 대한 기본적인 검증 ( 길이, 유효하지 않은 문자 포함 여부 )
	 * 2. 파싱된 입력값을 리턴할 수 있다. ( 내부적으로 Parser 를 사용한다 )
	 */
	@Test
	public void 제한길이보다_긴_입력으로_생성하려는경우_예외를던진다() {
		String expression = "1 + 2 + 3 * 1 + 234 - 1111";
		Assertions.assertThrows(
			IllegalArgumentException.class, () -> new Input(expression, blankParser)
		);
	}

	@Test
	public void 빈_문자열을_입력으로_생성하려는경우_예외를던진다() {
		String expression = "";
		Assertions.assertThrows(
			IllegalArgumentException.class, () -> new Input(expression, blankParser)
		);
	}

	@Test
	public void 유효하지않은_문자가포함된_입력으로_생성하려는경우_예외를던진다() {
		String expression = "1 + 2 + 3 * 1 + # 234";
		Assertions.assertThrows(
			IllegalArgumentException.class, () -> new Input(expression, blankParser)
		);
	}

	@Test
	public void 제약조건을_만족하는_입력으로_생성하려는경우_생성성공() {
		String expression = "1 + 3 / 1 - 11 * 1";
		Input success = new Input(expression, blankParser);
		Assertions.assertEquals( expression, success.getOriginalExpression());
	}

	@Test
	public void 입력값을_파싱한_결과를_제공한다() {
		Input validInput = new Input("1 + 2 * 3 - 1", blankParser);
		String[] expected = new String[]{"1", "+", "2", "*", "3", "-", "1"};

		Assertions.assertTrue(
			Arrays.equals(expected, validInput.getParsedInput())
		);
	}

}
