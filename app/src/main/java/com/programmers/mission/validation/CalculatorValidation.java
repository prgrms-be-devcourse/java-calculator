package com.programmers.mission.validation;

import java.util.Arrays;
import java.util.List;

import com.programmers.mission.model.MenuType;
import com.programmers.mission.model.OperatorType;
import com.programmers.mission.utils.ParserUtils;
import com.programmers.mission.utils.PatternUtils;

/**
 * what :RULE
 *  - 연산 표현식 " " 로 구분
 *  - 자연수 숫자만 취급
 *  - 괄호 문자 포함 x
 *  - 숫자들은 숫자로 이루어져 있는지 혹은 연산자로 이루어져 있는지 true & false 반환
 */
public class CalculatorValidation implements InputValidation {

	@Override
	public boolean isProperExpression(String expression) {
		if (!isNumericHeadAndTail(expression)) {
			return false;
		}

		List<String> splitExpression = ParserUtils.getSplitExpression(expression);

		return splitExpression.stream()
				.filter(value -> OperatorType.getValue(value).isEmpty())
				.allMatch(this::isConsistOfNumberAndOperator);
	}

	@Override
	public boolean isMatchServiceType(String input) {
		return Arrays.stream(MenuType.values()).anyMatch(menu -> menu.isService(input));
	}

	/**
	 * What : 첫문자 끝문자 숫자인지 판별
	 * why : 연산자가 첫번째로 나오면 안되기 때문
	 */
	private boolean isNumericHeadAndTail(String expression) {
		return Character.isDigit(expression.charAt(expression.length() - 1)) && Character.isDigit(expression.charAt(0));
	}

	private boolean isConsistOfNumberAndOperator(String word) {
		return PatternUtils.isOperator(word) || PatternUtils.isNumeric(word);
	}
}
