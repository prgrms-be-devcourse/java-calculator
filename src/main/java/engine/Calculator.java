package engine;

import engine.io.Input;
import engine.io.Output;
import engine.model.Element;
import engine.model.Function;
import engine.model.Record;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class Calculator implements Runnable {

    private Output output;
    private Input input;
    private Function function;
    private Record record;

    @Override
    public void run() {
        while (true) {
            output.outputFunction(function);
            String inputString = input.inputFunction("선택 : ");
            Optional<Integer> inputFunctionNumber = function.check(inputString);
            if (inputFunctionNumber.isEmpty()) {
                output.inputFunctionError();
                continue;
            }
            if (inputFunctionNumber.get().equals(1)) { //enum사용하도록 변경
                output.printRecord(record);
            }
            if (inputFunctionNumber.get().equals(2)) {
                Element element = new Element(new Stack<Integer>(), new Stack<Character>());
                Optional<String> expression = parse(input.inputExpression(), element.getCalculateOperators());
                if (expression.isEmpty()) {
                    output.inputExpressionError();
                    continue;
                }

                int answer = calculate(expression.get().replaceAll(" ", ""), element);
                output.outputCalculateAnswer(answer);
                record.addRecord(expression.get(), answer);
            }
        }
    }


    private Optional<String> parse(String expression, List<Character> calculateOperators) {
        boolean isCorrectExpression = expression.trim().chars()
                .filter(c -> c != '*' && c != '+' && c != '/' && c != '-')
                .allMatch(c -> c >= '0' && c <= '9');
        if (!isCorrectExpression) return Optional.empty();

        isCorrectExpression = calculateOperators.stream().anyMatch(c -> expression.trim().endsWith(Character.toString(c)));
        //startwith 으로 변경필요
        if (isCorrectExpression) return Optional.empty();
        if (expression.trim().equals("")) return Optional.empty();

        boolean needCheck = false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                needCheck = true;
                continue;
            }
            if (!stack.isEmpty()) {
                if (calculateOperators.stream().anyMatch(c -> c.equals(stack.peek()) && stack.peek().equals(ch)))
                    return Optional.empty();
            }
            if (needCheck) {
                if ((ch >= '0' && ch <= '9') && (stack.peek() >= '0' && stack.peek() <= '9')) return Optional.empty();
            }
            needCheck = false;
            stack.push(ch);
        }
        return Optional.of(expression);
    }

    private int calculate(String expression, Element element) {
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+') {
                element.getOperation().push(c);
                element.getNumbers().push(Integer.parseInt(str1));
                str1 = "";
            }
            if (c == '*' || c == '/') {
                for (int j = i + 1; j < expression.length(); j++) {
                    if (expression.charAt(j) >= '0' && expression.charAt(j) <= '9') {
                        str2 += expression.charAt(j);
                        i++;
                    }
                    if (!(expression.charAt(j) >= '0' && expression.charAt(j) <= '9')) break;
                }
                if (c == '*') str1 = Integer.toString(Integer.parseInt(str1) * Integer.parseInt(str2));
                if (c == '/') str1 = Integer.toString(Integer.parseInt(str1) / Integer.parseInt(str2));
                str2 = "";
            }
            if (c >= '0' && c <= '9') {
                str1 += c;
            }
        }
        int answer = Integer.parseInt(str1);
        int size = element.getNumbers().size();
        for (int i = 0; i < size; i++) {
            if (element.getOperation().peek() == '+') {
                answer += element.getNumbers().peek();
            }
            if (element.getOperation().peek() == '-') {
                answer -= element.getNumbers().peek();
            }
            element.getOperation().pop();
            element.getNumbers().pop();
        }
        return answer;
    }

}
