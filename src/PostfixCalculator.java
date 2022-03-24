import repository.CalcRepository;
import repository.InMemoryRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class PostfixCalculator implements Calculator {

    private final BufferedReader br;
    private final CalcRepository repository;
    private final ExpressionConverter converter;

    public PostfixCalculator(BufferedReader br, CalcRepository repository, ExpressionConverter converter) {
        this.br = br;
        this.repository = repository;
        this.converter = converter;
    }

    public void run() throws IOException {

        while (true) {

            System.out.print("1. 조회\n2. 계산\n\n선택: ");

            int command = Integer.parseInt(br.readLine());
            System.out.println();
            if (command == 1) {
                System.out.println(repository.getResults());
                continue;
            }

            if (command == 2) {
                String expression = br.readLine();
                System.out.println();
                List<String> converted = converter.convert(expression);
                double result = calculate(converted);
                repository.save(expression, result);
                System.out.println(result);
            }

            if(command == 3) break;

        }
    }

    public double calculate(List<String> expression){

        Stack<Double> stack = new Stack<>();

        for (String s : expression) {

            if(Opcode.isOperator(s)){
                double op2 = stack.pop();
                double op1 = stack.pop();

                double result = Opcode.findOperator(s).calculate(op1, op2);
                stack.push(result);
                continue;
            }

            stack.push(Double.parseDouble(s));

        }

        return stack.pop();
    }

}
