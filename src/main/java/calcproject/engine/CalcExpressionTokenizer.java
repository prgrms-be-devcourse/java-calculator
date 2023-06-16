package calcproject.engine;

import java.util.ArrayList;
import java.util.List;

public class CalcExpressionTokenizer {
	public List<String> tokenizeExpression(String expression) {
		List<String> tokens = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (char element : expression.toCharArray()) {
			if (Character.isDigit(element)) {
				sb.append(element);
			} else {
				String numberString = sb.toString();
				tokens.add(numberString);

				sb.setLength(0);
				tokens.add(Character.toString(element));
			}
		}

		if (sb.length() > 0) {
			String numberString = sb.toString();
			tokens.add(numberString);
		}

		return tokens;
	}
}
