package com.programmers.java.calculator.model;

public class Problem {
    private String[] question;
    private int answer;

    public Problem makeQuestionArray(String questionString){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questionString.length(); i++) {
            if(isOperator(questionString.charAt(i))){
                addWhiteSpace(sb, questionString, i);
                continue;
            }
            sb.append(questionString.charAt(i));
        }

        this.question = makeWhiteSpaceToOne(sb);
        return this;
    }

    private boolean isOperator(char letter) {
        switch (letter)
        {
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
                return true;
        }
        return false;
    }

    /**
     * 수식기호 양 옆에 whitespace 추가
     */
    private void addWhiteSpace(StringBuilder sb, String input, int i) {
        sb.append(" ");
        sb.append(input.charAt(i));
        sb.append(" ");
    }

    /**
     * whiteSpace의 길이가 2이상이라면 정규식표현에 따라 그 길이를 하나로 줄여주는 함수
     */
    private String[] makeWhiteSpaceToOne(StringBuilder sb) {
        String[] exp = sb.toString()
                .replaceAll(" +", " ")
                .split(" ");
        return exp;
    }

}
