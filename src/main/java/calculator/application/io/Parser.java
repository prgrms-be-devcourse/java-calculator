package calculator.application.io;

import calculator.application.io.enums.Characters;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> toList(String literal) {
        String[] characters = literal.split(Characters.BLANK.toString());
        return Arrays.asList(characters);
    }
}
