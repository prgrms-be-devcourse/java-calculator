package org.example.compute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Compute {
    default List<String> convertToToken(String infix) {
        List<String> tokens = new ArrayList<>(Arrays.asList(infix.split(" ")));
        return tokens;
    }

    List<String> convertTokenToPostfix(List<String> tokens);

    long calculate(List<String> postfix);

    long compute(String input);
}
