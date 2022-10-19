import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Calculator implements ICalculator {
    private final IHistory history = new History();

    // 검증된 operation 을 계산
    Double calculate(String operation) {
        // history 에 존재하면 곧바로 반환
        if (history.isExist(operation)) return history.getResult(operation);

        List<Token> tokenList = Token.makeTokenList(operation);
        List<Token> postfixTokenList = Token.postfixConverter(tokenList);

        Stack<Double> stack = new Stack<>();
        System.out.println("token list");
        for(var token : postfixTokenList){
            System.out.print(token.getData());
        }
        System.out.println();

        for (var token : postfixTokenList) {
            if(token.getType() == Token.NUMBER) {
                stack.push(token.convertData2Number());
                continue;
            }

            if(stack.size() < 2) break;
            Double a = stack.pop();
            Double b = stack.pop();

            switch(token.getOperator()){
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
        Double calcResult = stack.pop();//
        history.save(operation, calcResult);
        return calcResult;
    }

    List<String> getHistory() {
        return history.getList();
    }


}
