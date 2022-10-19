package engine;

import engine.model.Element;
import engine.model.Function;
import engine.model.Record;
import lombok.AllArgsConstructor;
import utility.Console;
import utility.Utility;

import java.util.*;

@AllArgsConstructor
public class Calculator implements Runnable {

    private Console console;
    private Record record;
    private static final Function function = new Function();
    private static final String FUNCTION_ONE = "1";
    private static final String FUNCTION_TWO = "2";
    private static final String FUNCTION_THREE = "3";


    @Override
    public void run() {
        while (true) {
            console.printFunction(function);
            String inputString = console.inputFunction("선택 : ");

            switch (inputString) {
                case FUNCTION_ONE:
                    console.printRecord(record);
                    break;

                case FUNCTION_TWO:
                    Element element = new Element(new Stack<Integer>(), new Stack<Character>());
                    String expression = console.inputExpression();
                    if (!isExpressionCorrect(expression, element.getCalculateOperators())) {
                        console.inputExpressionError();
                        continue;
                    }

                    int answer = calculate(expression.replace(" ", ""), element);
                    console.outputCalculateAnswer(answer);
                    record.addRecord(expression, answer);
                    break;

                case FUNCTION_THREE:
                    console.printExitMessage();
                    return;

                default:
                    console.inputFunctionError();
            }
        }
    }


    private boolean isExpressionCorrect(String expression, List<Character> calculateOperators) {

        boolean isCorrectExpression = expression.replace(" ", "").chars()
                .filter(c -> !calculateOperators.contains((char) c))
                .allMatch(c -> Utility.isNumber((char) c));
        if (!isCorrectExpression) return false;

        isCorrectExpression = calculateOperators.stream()
                .anyMatch(c -> expression.endsWith(Character.toString(c)) || expression.startsWith(Character.toString(c)));
        if (isCorrectExpression) return false;

        if (expression.isBlank()) return false;

        if (!isOrderCorrect(expression, calculateOperators)) return false;

        return true;
    }

    private boolean isOrderCorrect(String expression, List<Character> calculateOperators) {
        boolean needCheck = false;
        Stack<Character> stack = new Stack<Character>();
        char expressionArr[] = expression.toCharArray();
        for (char ch : expressionArr) {
            if (ch == ' ') {
                needCheck = true;
                continue;
            }
            if (!stack.isEmpty()) {
                if (calculateOperators.stream().anyMatch(c -> c.equals(stack.peek()) && stack.peek().equals(ch)))
                    return false;
            }
            if (needCheck) {
                if (Utility.isNumber(ch) && Utility.isNumber(stack.peek())) return false;
            }
            needCheck = false;
            stack.push(ch);
        }
        return true;
    }

    private int calculate(String expression, Element element) {

        int answer = doMultipleAndDivideFirst(expression, element);
        answer = doAddAndSubtractNext(answer, element);
        return answer;
    }

    private int doMultipleAndDivideFirst(String expression, Element element) {

        StringBuffer str1 = new StringBuffer("");
        StringBuffer str2 = new StringBuffer("");
        int midResult = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '-' || c == '+') {
                element.getOperation().push(c);
                element.getNumbers().push(Utility.bufferStringToInt(str1));
                str1.setLength(0);
            }
            if (c == '*' || c == '/') {
                for (int j = i + 1; j < expression.length(); j++) {
                    if (Utility.isNumber(expression.charAt(j))) {
                        str2.append(expression.charAt(j));
                        i++;
                    }
                    if (!Utility.isNumber(expression.charAt(j))) break;
                }

                if (c == '*') midResult = Utility.bufferStringToInt(str1) * Utility.bufferStringToInt(str2);
                if (c == '/') midResult = Utility.bufferStringToInt(str1) / Utility.bufferStringToInt(str2);
                str1.setLength(0);
                str1.append(midResult);
                str2.setLength(0);
            }
            if (Utility.isNumber(c)) {
                str1.append(c);
            }
        }

        return Utility.bufferStringToInt(str1);
    }

    private int doAddAndSubtractNext(int midAnswer, Element element) {

        Stack<Integer> numbers = element.getNumbers();
        Stack<Character> operation = element.getOperation();
        int originalNumberStackSize = numbers.size();
        for (int i = 0; i < originalNumberStackSize; i++) {
            if (operation.peek() == '+') {
                midAnswer += numbers.peek();
            }
            if (operation.peek() == '-') {
                midAnswer = numbers.peek() - midAnswer;
            }
            operation.pop();
            numbers.pop();
        }

        return midAnswer;
    }

}
