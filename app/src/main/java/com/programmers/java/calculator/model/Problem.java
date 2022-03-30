package com.programmers.java.calculator.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Stack;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Problem {
    private String[] question;
    private int answer;

    public Problem makeQuestionArray(String questionString){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questionString.length(); i++) {
            char letter = questionString.charAt(i);
            if(isOperator(letter)){
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

    public Problem calculate() {
        String postfix = transformToPostfix();
        System.out.println("postfix = " + postfix);
        String[] str = postfix.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            int num1, num2;

            switch (s){
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(add(num2, num1));
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(subtract(num2, num1));
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(divide(num2, num1));
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(multiply(num2, num1));
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        this.answer = stack.pop();
        return this;
    }

    private static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private static int divide(int num1, int num2) {
        return num1 / num2;
    }

    private static int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private static int add(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * 후위 변환식으로 변환
     * @return String
     */
    private String transformToPostfix() {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        boolean flag = isFirstLetterWhiteSpace(sb);

        for (int i = flag?3:0; i<question.length; ++i) {
            String c = question[i];

            if (c.matches("[0-9]+[\\.]?[0-9]*")) {
                sb.append(c);
                sb.append(" ");
            } else if (c.equals("(")) {
                stack.push(c);
                sb.append(" ");
            } else if (c.equals(")")) {
                while (!stack.isEmpty() && stack.peek().equals("("))
                    sb.append(stack.pop());
                sb.append(" ");
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())){
                    sb.append(stack.pop());
                    sb.append(" ");
                }
                stack.push(c);
            }

        }

        while (!stack.isEmpty()){
            if(stack.peek() == "(")
                return "Invalid Expression";
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.toString();
    }

    /**
     * (+)조건: 해당 하는 수식을 맨처음 글자가 whitespace라면 flag를 통해 for문에 영향을준다.
     * @param sb
     * @return boolean
     */
    private boolean isFirstLetterWhiteSpace(StringBuilder sb) {
        boolean flag = false;

        if(question[0].equals("") && question[1].equals("-")){
            sb.append("0 ");
            sb.append(question[2]);
            sb.append(" - ");
            flag = true;
        }
        return flag;
    }

    /**
     * 해당하는 표기가 숫자인지 수식인지 그리고 수식이라면 수식에 따른 우선순위 번호를 매김
     * @param s
     * @return int
     */
    private int prec(String s) {
        switch (s)
        {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;
    }

    /**
     * toString 함수로 이후 편한 print를 위해 재구성
     * @return String     
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : question) {
            sb.append(s+" ");
        }
        sb.append("= ");
        sb.append(answer);

        return sb.toString();
    }
}
