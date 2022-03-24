package service;

import creator.CreatorManagement;
import creator.type.RepositoryType;
import entity.Expression;
import repository.CalculatorRepository;
import repository.InMemoryRepository;

import java.util.*;
import java.util.stream.Collectors;

public class CalculatorService {

    CalculatorRepository repository = CreatorManagement
            .createCalculatorRepository(RepositoryType.InMemory);

    private static final Map<Character, Integer> opPriorityMap = new HashMap<>() {{
        put('-', 1);
        put('+', 1);
        put('*', 2);
        put('/', 2);
    }};

    public void saveInput(String input, double result){
        repository.save(input,result);
    }

    public List<Expression> getHistory() {
        return repository.findAll()
                .stream()
                .sorted((o1, o2) -> o1.getId() < o2.getId() ? -1 : 1)
                .collect(Collectors.toList());
    }

    public double getResult(String input) {

        Stack<Double> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        String[] inputs = input.trim().split("\\s+");
        String numPattern = "^-?[0-9]+$";

        for (String value : inputs) {

            if (value.matches(numPattern)) {
                numStack.push(Double.parseDouble(value));
                continue;
            }

            // operand 검증 다른기호인지 3.25 체크 필요
            char op = value.charAt(0);

            if (opStack.isEmpty()) {
                opStack.push(op);
                continue;
            }

            // 연산자 비교
            if (isOperation(op, opStack.peek()))
                numStack.push(calc(numStack.pop(), numStack.pop(), opStack.pop()));

            opStack.push(op);
        }

        while(!opStack.isEmpty())
            numStack.push(calc(numStack.pop(),numStack.pop(),opStack.pop()));

        return numStack.pop();
    }

    private double calc(double num2, double num1, char op){

        if(op == '+')
            return num1 + num2;
        else if(op == '-')
            return num1 - num2;
        else if(op == '*')
            return num1 * num2;
        else
            return num1 / num2;
    }

    // 지금 넣어야할게 우선순위가 같거나 작으면 연산
    private boolean isOperation(char op, char stackOp) {

        if (opPriorityMap.get(op) <= opPriorityMap.get(stackOp))
            return true;
        else
            return false;

    }
}
