package programmers.calculator.controller;

import java.util.Arrays;
import java.util.List;

public class WhiteSpaceParser implements Parser{

  private static final String WHITE_SPACE_SPLIT_REGEX = "\\s";

  public List<String> parse(String input) {
    List<String> tokens = Arrays.asList(input.split(WHITE_SPACE_SPLIT_REGEX));
    Validator.validate(tokens);
    return tokens;
  }

}
