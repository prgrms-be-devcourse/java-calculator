package calcproject.engine;

import java.util.ArrayList;
import java.util.List;

public class CalcExpressionTokenizer {
	public List<String> tokenizeExpression(String expression) {
		List<String> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		expression = expression.replace(" ", "");

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (Character.isDigit(c)) {
				sb.append(c);
			} else {
				String numberString = sb.toString();
				tokens.add(numberString);
				sb.setLength(0);
				tokens.add(Character.toString(c));
			}
		}

		if (sb.length() > 0) {
			String numberString = sb.toString();
			tokens.add(numberString);
		}

		return tokens;
	}
}
