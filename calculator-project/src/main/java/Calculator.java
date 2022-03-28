import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator implements ICalculator {
    private final IHistory history = new History();

    // 검증된 operation 을 계산
    Double calculate(String operation) {
        // history 에 존재하면 곧바로 반환
        if (history.isExist(operation)) return history.getResult(operation);

        String postfixExpression = postfixConverter(operation); // infix -> postfix
        List<Character> expressionList = string2CharList(postfixExpression); // string -> List<Char>

        Stack<Double> stack = new Stack<>();
        for (var op : expressionList) {
            if(isNumber(op)) {
                stack.push(charToDouble(op));
                continue;
            }

            if(stack.size() < 2) break;
            Double a = stack.pop();
            Double b = stack.pop();

            switch(op){
                case '+':
                    stack.push(add(a,b));
                    break;
                case '-':
                    stack.push(sub(a,b));
                    break;
                case '*':
                    stack.push(mul(a,b));
                    break;
                case '/':
                    stack.push(div(a,b));
                    break;
            }
        }
        Double calcResult = stack.pop();
        history.save(operation, calcResult);
        return calcResult;
    }

    String postfixConverter(String operation){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < operation.length(); i++) {
            char op = operation.charAt(i);
            if(isOperator(op)){
                while (!stack.empty() && priority(op) <= priority(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(op);
            }
            else{
                postfix.append(op);
            }
        }

        while (!stack.empty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    boolean isOperator(char ch) {
        if (ch == '*' || ch == '/' || ch == '+' || ch == '-') return true;
        return false;
    }

    int priority(char ch) {
        if(ch == '+' || ch =='-') return 1;
        if(ch == '*' || ch =='/') return 2;
        return 0;
    }

    List<String> getHistory() {
        return history.getList();
    }

    /* 가독성을 위한 메서드(?) */
    List<Character> string2CharList(String str){
        return str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    }
    Double charToDouble(char ch){
        return Double.parseDouble(String.valueOf(ch));
    }
    boolean isNumber(char ch){
        return !isOperator(ch);
    }
}
