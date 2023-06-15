package calcproject.engine;

import java.util.ArrayList;
import java.util.List;

public class CalcExpressionTokenizer {
	public List<String> tokenizeExpression(String expression) {
		List<String> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (ch == ' ') {
				continue;
			}

			if (Character.isDigit(ch)) {
				sb.append(ch);
			} else {
				String numberString = sb.toString();
				tokens.add(numberString);
				sb.setLength(0);

				tokens.add(Character.toString(ch));
			}
		}

		if (sb.length() > 0) {
			String numberString = sb.toString();
			tokens.add(numberString);
		}

		return tokens;
	}
}
