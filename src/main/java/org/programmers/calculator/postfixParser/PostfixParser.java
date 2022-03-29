package org.programmers.calculator.postfixParser;

import java.util.List;

public interface PostfixParser {

    default List<String> parse(String input) {
        return toPostfix(input.split(" "));
    }

    List<String> toPostfix(String[] input);
}
