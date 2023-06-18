package me.kimihiqq;

import lombok.RequiredArgsConstructor;
import me.kimihiqq.io.Input;
import me.kimihiqq.io.Output;
import me.kimihiqq.model.History;
import me.kimihiqq.options.Option;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class Calculator {

    private final Input scanner;
    private final Output printer;
    private final History history;

    public boolean run() {
        printer.println("1. 조회\n2. 계산\n3. 종료\n");
        String selectPage = scanner.nextLine("선택 : ");
        Optional<Option> optionalOption = Option.from(selectPage);

        if (!optionalOption.isPresent()) {
            printer.println("Invalid page!");
            return true;
        }

        Option option = optionalOption.get();

        switch (option) {
            case LIST:
                list();
                return true;
            case CALCULATE:
                calculate();
                return true;
            case EXIT:
                printer.println("종료합니다.");
                return false;
        }

        return true;
    }

    public void calculate() {
        while (true) {
            try {
                String formula = scanner.nextLine();
                Pretreatment.validateFormula(formula);

                List<String> terms = Pretreatment.parseFormula(formula);

                terms = executeOperation(terms, Arrays.asList("*", "/"));
                terms = executeOperation(terms, Arrays.asList("+", "-"));

                printer.printResult(terms.get(0));
                saveHistory(formula, terms.get(0));

                break;
            } catch (IllegalArgumentException e) {
                printer.println(e.getMessage());
            }
        }
    }

    private List<String> executeOperation(List<String> terms, List<String> operators) {
        int i = 0;
        while (i < terms.size()) {
            if (operators.contains(terms.get(i))) {
                long leftHandSide = Long.parseLong(terms.get(i - 1));
                long rightHandSide = Long.parseLong(terms.get(i + 1));
                long result = calculateOperation(terms.get(i), leftHandSide, rightHandSide);

                for (int j = 0; j < 3; j++) {
                    terms.remove(i - 1);
                }
                terms.add(i - 1, String.valueOf(result));
            } else {
                i++;
            }
        }
        return terms;
    }

    private long calculateOperation(String operator, long leftHandSide, long rightHandSide) {
        switch (operator) {
            case "*":
                return leftHandSide * rightHandSide;
            case "/":
                return leftHandSide / rightHandSide;
            case "+":
                return leftHandSide + rightHandSide;
            case "-":
                return leftHandSide - rightHandSide;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private void saveHistory(String formula, String result) {
        StringBuffer sb = new StringBuffer();
        String historyItem = sb.append(formula)
                .append(" = ")
                .append(result)
                .toString();
        history.add(historyItem);
    }

    public void list() {
        Map<Integer, String> allHistory = history.getAll();
        for (Map.Entry<Integer, String> entry : allHistory.entrySet()) {
            printer.println(entry.getValue());
        }
        printer.println();
    }
}
