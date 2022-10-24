package calculator.application.io;

import calculator.application.io.enums.Characters;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> toList(String literal) {
        String[] characters = literal.split(Characters.BLANK.toString());
        return Arrays.asList(characters); // TODO: 띄어쓰기 유무, 개수에 상관없이 split 할 수 있게 수정
    }
}
