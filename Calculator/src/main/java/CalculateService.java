import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CalculateService implements CalculatorFunction {

    private String name;
    private LinkedList<String> expForCal = new LinkedList<>();
    private String result;
    static StringBuilder num = new StringBuilder();
    static Deque<String> queue = new LinkedList<>();

    public CalculateService(String name) {
        this.name = name;
    }

    @Override
    public void doService(Calculator calculator) {

        String expression;
        LinkedList<String> expForCal;
        String result;

        while (true) {
            try {
                expression = readExpression();
                expForCal = fullTextParsing(expression);
                result = calculate(expForCal);
                break;

            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
            }
        }

        System.out.println(result);

        calculator.getResultSaveService().save(new Result(expression, result));

    }

    public String calculate(LinkedList<String> expForCal) throws Exception {
        return plusOrMinus(divideOrMultiple(expForCal));
    }

    public String plusOrMinus(LinkedList<String> expression) {

        Double sum = Double.valueOf(0);

        while (!expression.isEmpty()) {
            String current = expression.pollFirst();

            if (current.equals("-")) {
                sum -= Double.valueOf(expression.pollFirst());
            } else if (current.equals("+")) {
                sum += Double.valueOf(expression.pollFirst());
            } else {
                sum += Double.valueOf(current);
            }
        }

        String result = String.valueOf(sum);
        int deciPoint = result.indexOf(".");

        // 정수 -> 소수점 제거
        if (deciPoint == result.length() - 2 && result.charAt(deciPoint + 1) == '0') {
            return String.valueOf((Math.round(sum)));
        }

        return String.valueOf(sum);
    }

    public LinkedList<String> divideOrMultiple(LinkedList<String> expForCal) throws Exception {

        Double v;

        while (!expForCal.isEmpty()) {
            String peek = expForCal.peek();

            if (peek.equals("*")) {
                expForCal.pollFirst();
                v = Double.parseDouble(queue.pollLast()) * Double.parseDouble(expForCal.poll());
                queue.add(String.valueOf(v));

            } else if (peek.equals("/")) {
                expForCal.pollFirst();
                v = Double.parseDouble(queue.pollLast()) / Double.parseDouble(expForCal.poll());

                if (v.isInfinite() || v.isNaN()) {
                    System.out.print("0 으로 나눌 수 없습니다. ");
                    throw new ArithmeticException();
                }

                queue.add(String.valueOf(v));
            } else {
                String poll = expForCal.pollFirst();
                queue.add(poll);
            }

        }

        queue.stream().forEach(o -> expForCal.add(o));
        queue.clear();
        return expForCal;
    }

    public String readExpression() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String inputRefined = input.replaceAll("\\s", "");
        return inputRefined;
    }

    public LinkedList<String> fullTextParsing(String inputRefined) throws Exception {

        LinkedList<String> equationElements = new LinkedList<>();

        if (!isValidFormula(inputRefined)) {
            System.out.printf("계산식이 올바르지 않습니다. ");
            throw new Exception("BAD_INPUT");
        }

        for (int i = 0; i < inputRefined.length(); i++) {
            char c = inputRefined.charAt(i);

            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                if (!num.isEmpty()) equationElements.add(num.toString());
                num.setLength(0);
                equationElements.add(c + "");
            }
        }

        equationElements.add(num.toString());
        num.setLength(0);

        return equationElements;
    }

    public boolean isValidFormula(String inputRefined) {

        boolean startWithNum = true;
        boolean onlyAllowed = true;

        char firstChar = inputRefined.charAt(0);

        if (firstChar == '+' || firstChar == '*' || firstChar == '/') {
            System.out.println("유효하지 않은 수식입니다!");
            startWithNum = false;
        }

        if (!inputRefined.matches("^([0-9/./+/*///-]*)[0-9]$")) {
            onlyAllowed = false;
        }

        return startWithNum && onlyAllowed;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
