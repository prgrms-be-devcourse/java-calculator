import entity.CustomLog;
import exception.CalculatorException;
import repository.LogRepository;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class PostfixCalculator implements Calculator {

    private final BufferedReader br;
    private final LogRepository repository;
    private final ExpressionConverter converter;

    public PostfixCalculator(BufferedReader br, LogRepository repository, ExpressionConverter converter) {
        this.br = br;
        this.repository = repository;
        this.converter = converter;
    }

    /**
     * 3 입력시 종료
     * 1, 2, 3 이외 입력시 다시 입력받습니다.
     */
    public void run() {

        while (true) {
            int command;
            try {
                System.out.print("1. 조회\n2. 계산\n3. 종료\n\n선택: ");
                command = Integer.parseInt(br.readLine());
                System.out.println();

                if (command == 1) {
                    printHistory();
                    continue;
                }

                if (command == 2) {
                    String expression = br.readLine();
                    String result = getResult(expression);
                    System.out.println(result);
                    repository.save(new CustomLog(expression, result));
                    System.out.println();
                    continue;
                }

                if (command == 3) return;

                System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    /**
     * repository에서 이력을 출력합니다.
     */
    public void printHistory() {
        List all = repository.getAll();
        StringBuilder sb = new StringBuilder();
        all.forEach(log -> sb.append(log.toString()).append("\n"));
        System.out.println(sb);
    }

    /**
     * result 값에 따라서 출력형식을 변환하여 반환합니다.
     *
     * @param expression
     * @return result값을 적절하게 변경하여 String 으로 반환합니다.
     */
    public String getResult(String expression) {
        List<String> converted = converter.convert(expression);
        double result = calculate(converted).orElseThrow(() -> new CalculatorException("올바르지 않은 연산식입니다."));

        if (Double.isInfinite(result)) {
            return String.valueOf(result);
        }

        if (result == Math.ceil(result)) {
            return String.valueOf((long) result);
        }

        BigDecimal bigDecimal = new BigDecimal(result).setScale(15, RoundingMode.HALF_UP).stripTrailingZeros();
        return String.valueOf(bigDecimal);
    }


    /**
     * 계산 끝에 stack이 완전히 비워지지 않거나, 계산도중 stack이 비면 예외를 던집니다.
     *
     * @param expression
     * @return Postfix expression을 계산한 값을 double로 반환합니다.
     * @throws CalculatorException
     */
    public Optional<Double> calculate(List<String> expression) {

        Stack<Double> stack = new Stack<>();
        Optional<Double> answer;

        try {
            for (String s : expression) {
                Optional<Opcode> findOperator = Opcode.findOperator(s);

                if (findOperator.isPresent()) {
                    double op2 = stack.pop();
                    double op1 = stack.pop();

                    double result = findOperator.get().calculate(op1, op2);
                    stack.push(result);
                    continue;
                }

                stack.push(Double.parseDouble(s));

            }

            answer = Optional.of(stack.pop());

            if (!stack.isEmpty()) return Optional.empty();

        } catch (EmptyStackException e) {
            return Optional.empty();
        }

        return answer;
    }

}
