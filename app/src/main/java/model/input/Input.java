package model.input;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.regex.Pattern;

public class Input {

	private final String originalExpression;
	private final Parser parser;
	private final String patternString = "[^\\d\\+\\-\\*\\/\\s]";
	private final int MAX_LENGTH = 18;
	private final int MIN_LENGTH = 1;


	public Input(String expression, Parser parser) {
		checkArgument(expression != null, "주어지는 식이 null 일 수 없습니다");
		checkArgument(parser != null, "파서는 null 일 수 없습니다");
		checkArgument(expression.length() <= MAX_LENGTH && expression.length() >= MIN_LENGTH,
			"식의 길이는 " + MIN_LENGTH + " 이상 " + MAX_LENGTH + " 이하여야합니다");

		validateByRegex(expression);

		this.originalExpression = expression;
		this.parser = parser;
	}

	// 유효하지 않은 글자 포함 여부 검증
	private void validateByRegex(String expression) {
		Pattern pattern = Pattern.compile(patternString);
		if (pattern.matcher(expression).find()) {
			throw new IllegalArgumentException("식에 유효하지 않은값이 포함되어있습니다");
		}
	}

	public String[] getParsedInput() {
		return parser.parse(originalExpression);
	}

	public String getOriginalExpression() {
		return originalExpression;
	}
}
