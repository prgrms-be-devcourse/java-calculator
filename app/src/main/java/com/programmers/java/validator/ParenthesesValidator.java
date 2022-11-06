package com.programmers.java.validator;

public class ParenthesesValidator implements InputValidator {
    @Override
    public boolean validate(String input) {
        int cnt = 0;
        input = input.replaceAll("\\s","");
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                cnt++;
            } else if (input.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    @Override
    public void printErrorMessage() {
        System.out.println("올바르지 않은 괄호를 가지고 있습니다.");
    }
}
