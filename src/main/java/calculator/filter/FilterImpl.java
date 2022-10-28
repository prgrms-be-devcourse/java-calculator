package calculator.filter;

import java.text.DecimalFormat;
import java.util.Stack;

public class FilterImpl implements Filter {
    @Override
    public int isSelect(String line) {
        if (line.equals("1") || line.equals("2") || line.equals("3")) return Integer.parseInt(line);
        return -1;
    }

    @Override
    public String clearSpace(String line) {
        return line.replaceAll(" ", "");
    }

    @Override
    public Stack<String> changeStringToStack(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char x : str.toCharArray()) {
            if (x == '+' || x == '-' || x == '*' || x == '/') {
                stack.push(sb.toString());
                stack.push(String.valueOf(x));
                sb.setLength(0);    // StringBuilder 초기화
            }
            else sb.append(x);
        }
        stack.push(sb.toString());
        return stack;
    }

    @Override
    public String formatResult(double calculateResult) {
        DecimalFormat df = new DecimalFormat("#.##########");
        return df.format(calculateResult);
    }

    @Override
    public String keyMapping(String s) {
        String answer = "";
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                answer += " " + c + " ";
            } else answer += c;
        }
        return answer;
    }

    @Override
    public boolean validate(String s) {
        if (firstLastIsNotDigit(s)) return false;
        if (KoreanOrAlphabet(s)) return false;
        if (isRepeatOperator(s)) return false;
        if (divideByZero(s)) return false;
        return true;
    }

    private boolean firstLastIsNotDigit(String s) {
        return (!Character.isDigit(s.charAt(0)) || !Character.isDigit(s.charAt(s.length() - 1)));
    }

    private boolean KoreanOrAlphabet(String s) {
        return s.matches("/^[가-힣a-zA-Z]+$/;");
    }

    private boolean isRepeatOperator(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (!Character.isDigit(s.charAt(i)) && !Character.isDigit(s.charAt(i + 1))) return true;
        }
        return false;
    }

    private boolean divideByZero(String s) {
        return s.charAt(s.indexOf("/") + 1) == '0';
    }
}
