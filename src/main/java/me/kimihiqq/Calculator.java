package me.kimihiqq;

import lombok.RequiredArgsConstructor;
import me.kimihiqq.io.Input;
import me.kimihiqq.io.Output;
import me.kimihiqq.model.History;
import me.kimihiqq.options.Operator;
import me.kimihiqq.options.Option;
import me.kimihiqq.utils.FormulaProcessor;

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
        if(selectPage == null || !selectPage.matches("[1-3]")) {
            throw new IllegalArgumentException("Invalid page!");
        }
        Optional<Option> optionalOption = Option.from(selectPage);

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
                FormulaProcessor.validateFormula(formula);

                List<String> terms = FormulaProcessor.parseFormula(formula);

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
                double leftHandSide = Double.parseDouble(terms.get(i - 1));
                double rightHandSide = Double.parseDouble(terms.get(i + 1));
                double result = calculateOperation(terms.get(i), leftHandSide, rightHandSide);

                terms.subList(i - 1, i + 2).clear();
                terms.add(i - 1, String.valueOf(result));
            } else {
                i++;
            }
        }
        return terms;
    }

    private double calculateOperation(String operatorString, double leftHandSide, double rightHandSide) {
        Optional<Operator> optionalOperator = Operator.from(operatorString);
        if (!optionalOperator.isPresent()) {
            throw new IllegalArgumentException("Invalid operator");
        }

        Operator operator = optionalOperator.get();
        return operator.calculate(leftHandSide, rightHandSide);
    }

    private void saveHistory(String formula, String result) {
        StringBuilder sb = new StringBuilder();
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
