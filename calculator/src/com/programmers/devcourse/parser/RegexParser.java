package com.programmers.devcourse.parser;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser implements Parser {

  private final String pattern = "([+*-/])|([0-9]{1,7}(\\.[0-9]{1,7})?)";


  @Override
  public List<String> parse(String target) {

    Matcher matcher = Pattern.compile(pattern).matcher(target);
    int i = 0;
    List<String> matchedTokens = new LinkedList<>();
    while (matcher.find()) {
      String group = matcher.group();
      matchedTokens.add(group);
      i++;
    }
    return matchedTokens;
  }


}
