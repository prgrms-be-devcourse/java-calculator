package com.programmers.devcourse.parser;

import com.programmers.devcourse.exception.parser.ParserException;
import com.programmers.devcourse.exception.parser.WrongTokenCountException;
import com.programmers.devcourse.exception.parser.WrongTokenPositionException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser implements Parser {

  private final String pattern = "([+*-/])|([0-9]{1,7}(\\.[0-9]{1,7})?)";
  private final String operatorPattern;
  private final String numberPattern;


  public RegexParser() {
    String[] dividedPatterns = pattern.split("\\|");
    operatorPattern = dividedPatterns[0];
    numberPattern = dividedPatterns[1];
  }

  @Override
  public List<String> parse(String target) throws ParserException {

    Matcher matcher = Pattern.compile(pattern).matcher(target);
    return mapMatcherToTokenList(matcher);
  }

  private List<String> mapMatcherToTokenList(Matcher matcher) throws ParserException {
    List<String> matchedTokens = new LinkedList<>();

    int tokenCount = 0;
    while (matcher.find()) {
      String group = matcher.group();
      if (tokenCount % 2 == 0 && !group.matches(numberPattern)) {
        throw new WrongTokenPositionException();
      }

      if (tokenCount % 2 != 0 && !group.matches(operatorPattern)) {
        throw new WrongTokenPositionException();
      }
      matchedTokens.add(group);
      tokenCount++;
    }
    if (tokenCount == 1 || tokenCount % 2 == 0) {
      // 토큰이 한 개만 or 토큰의 개수가 짝수면 연산이 올바르게 되지 않는다.
      throw new WrongTokenCountException();
    }
    return matchedTokens;
  }


}
