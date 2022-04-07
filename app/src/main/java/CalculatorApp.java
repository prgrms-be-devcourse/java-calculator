import io.Input;
import io.Output;
import model.Expression;
import repository.ResultRepository;

import java.util.ArrayList;
import java.util.List;

public class CalculatorApp implements Runnable {

    private static final String RECORD = "1";
    private static final String CALCULATE = "2";

    Input input;
    Output output;
    ResultRepository resultRepository;

    public CalculatorApp(Input input, Output output, ResultRepository resultRepository) {
        this.input = input;
        this.output = output;
        this.resultRepository = resultRepository;
    }

    @Override
    public void run() {

        Long sequence = 0L;

        while (true) {
            String option = input.showOption();

            if (option.equals(RECORD)) {
                List<Expression> history = resultRepository.findAll();
                output.showHistory(history);
            } else {
                boolean isNumeric = option.chars().allMatch(Character::isDigit);
                if (!isNumeric) {
                    System.out.println("숫자를 입력해주세요.");
                    continue;
                }
                if (option.equals(RECORD) && option.equals(CALCULATE)) {
                    System.out.println("1과 2중에서 하나만 골라주세요.");
                    continue;
                }

                String userInput = input.inputForCalculate();
                Double result = calculate(parse(userInput));
                System.out.println(result);

                Expression expression = new Expression(++sequence, userInput, result);
                resultRepository.save(expression);
            }

        }

    }

    public String[] parse(String userInput) {
        return userInput.split(" ");
    }

    public double calculate(String[] userInputSplit) {
        List<String> calList = new ArrayList<>();

        Double result;
        for (int i = 0; i < userInputSplit.length - 1; i += 2) {
            String first = userInputSplit[i];
            String operator = userInputSplit[i + 1];
            String second = userInputSplit[i + 2];

            if (operator.equals("+") || operator.equals("-")) {
                calList.add(first);
                calList.add(operator);
            } else if (operator.equals("*")) {
                userInputSplit[i + 2] = String.valueOf(Double.parseDouble(first) * Double.parseDouble(second));
            } else {
                if (second.equals("0")) throw new ArithmeticException("0으로 나눌 수 없습니다.");
                userInputSplit[i + 2] = String.valueOf(Double.parseDouble(first) / Double.parseDouble(second));
            }
        }

        calList.add(userInputSplit[userInputSplit.length - 1]);

        result = Double.parseDouble(calList.get(0));

        for (int i = 1; i < calList.size(); i += 2) {
            if (calList.get(i).equals("+")) {
                result += Double.valueOf(calList.get(i + 1));
            } else if (calList.get(i).equals("-")) {
                result -= Double.valueOf(calList.get(i + 1));
            }
        }

        return result;
    }


}
