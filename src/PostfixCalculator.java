import exception.CalculatorException;
import repository.CalcRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
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

    public void run() {

        int command;
        while (true) {
            try {
                System.out.print("1. 조회\n2. 계산\n\n선택: ");
                command = Integer.parseInt(br.readLine());
                System.out.println();

                if (command == 1) {
                    printHistory();
                    continue;
                }

                if (command == 2) {
                    String expression = br.readLine();
                    System.out.println();
                    operate(expression);
                    continue;
                }

                if (command == 3) break;

                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void printHistory() {
        System.out.println(repository.getAll());
    }

    private void operate(String expression) {
        List<String> converted = converter.convert(expression);
        double result = calculate(converted);

        if (result == Math.ceil(result)) {
            repository.save(expression, (long) result);
            System.out.println((long) result);
            return;
        }

        BigDecimal bigDecimal = new BigDecimal(result).setScale(3, RoundingMode.HALF_EVEN);
        repository.save(expression, bigDecimal);
        System.out.println(bigDecimal);
    }


    public double calculate(List<String> expression) throws CalculatorException {

        Stack<Double> stack = new Stack<>();
        double answer;
        try {
            for (String s : expression) {

                if (Opcode.isOperator(s)) {
                    double op2 = stack.pop();
                    double op1 = stack.pop();

                    double result = Opcode.findOperator(s).calculate(op1, op2);
                    stack.push(result);
                    continue;
                }

                stack.push(Double.parseDouble(s));

            }
            answer = stack.pop();

            if (!stack.isEmpty()) throw new CalculatorException("올바르지 않은 연산식입니다. :" + expression);

        } catch (EmptyStackException e) {
            throw new CalculatorException("단항연산자는 허용하지 않습니다. ex: 1+(-3)");
        }
        return answer;
    }

}
