package service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Set;

public class ValidatorImpl implements Validator{

    @Override
    public void validateFormat(ArrayList<Object> postFix) {
        if(postFix.size()==0 || postFix.size()%2==0) {
            throw new EmptyStackException();
        }
    }

    @Override
    public void validateCharacter(Set<Character> characters, char c) {
        characters.stream().filter(e-> e== c)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 수식을 입력하세요"));
    }

    @Override
    public double validateDouble(String tmp) {
        try {
            return Double.parseDouble(tmp);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력하세요");
        }
    }
}
