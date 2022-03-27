package service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Set;

public interface Validator {
    void validateFormat(ArrayList<Object> postFix);

    void validateCharacter(Set<Character> characters, char c);

    double validateDouble(String tmp);
}
