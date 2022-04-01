package com.programmers.devcourse.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.programmers.devcourse.exception.parser.NotAcceptableStringException;
import com.programmers.devcourse.exception.parser.ParserException;
import com.programmers.devcourse.exception.parser.WrongTokenCountException;
import com.programmers.devcourse.exception.parser.WrongTokenPositionException;

public class RegexParser implements Parser {

	private static final Pattern pattern = Pattern.compile("([+*-/])|([0-9]{1,7}(\\.[0-9]{1,7})?)");
	private static final Pattern operatorPattern = Pattern.compile("[+*-/]");
	private static final Pattern numberPattern = Pattern.compile("[0-9]{1,7}(\\.[0-9]{1,7})?");
	private static final Pattern acceptablePattern = Pattern.compile(
		"^(([+*-/])|([0-9]{1,7}(\\.[0-9]{1,7})?)|\\s)+$");

	@Override
	public List<String> parse(String target) throws ParserException {
		// 숫자, 연산자 외 부적합한 기호가 들어왔다?
		if (!acceptablePattern.matcher(target).matches()) {
			throw new NotAcceptableStringException();
		}

		Matcher matcher = pattern.matcher(target);
		return mapMatcherToTokenList(matcher);
	}

	private List<String> mapMatcherToTokenList(Matcher matcher) throws ParserException {
		List<String> matchedTokens = new LinkedList<>();

		int tokenCount = 0;
		while (matcher.find()) {
			String group = matcher.group();
			if (isNumberInWrongPosition(tokenCount, group) ||
				isOperatorInWrongPosition(tokenCount, group)) {
				throw new WrongTokenPositionException();
			}

			matchedTokens.add(group);
			tokenCount++;
		}

		if (isAppropriateTokenCount(tokenCount)) {
			// 토큰이 한 개만 or 토큰의 개수가 짝수면 연산이 올바르게 되지 않는다.
			throw new WrongTokenCountException();
		}
		return matchedTokens;
	}

	private boolean isAppropriateTokenCount(int tokenCount) {
		return tokenCount == 1 || tokenCount % 2 == 0;
	}

	private boolean isOperatorInWrongPosition(int tokenCount, String group) {
		return tokenCount % 2 != 0 && !operatorPattern.matcher(group).matches();
	}

	private boolean isNumberInWrongPosition(int tokenCount, String group) {
		return tokenCount % 2 == 0 && !numberPattern.matcher(group).matches();
	}

}
