package example.calculator.model;

import example.calculator.model.operation.Addition;
import example.calculator.model.operation.CalculationOperation;
import example.calculator.model.operation.Division;
import example.calculator.model.operation.Multiplication;
import example.calculator.model.operation.Subtraction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Calculator {
    private static final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/]");
    private Map<String, CalculationOperation> calculationOperations;
    private List<String> calculationHistory;

    public Calculator() {
        calculationOperations = new HashMap<>();
        calculationOperations.put("*", new Multiplication());
        calculationOperations.put("/", new Division());
        calculationOperations.put("+", new Addition());
        calculationOperations.put("-", new Subtraction());

        calculationHistory = new ArrayList<>();
    }

    public List<String> getCalculationHistory() {
        return calculationHistory;
    }

    public double calculate(double a, double b, String operator) {
        CalculationOperation operation = calculationOperations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        return operation.calculate(a, b);
    }

    private void addToCalculationHistory(String expression) {
        calculationHistory.add(expression);
    }

    public double handleCalculation(String[] tokens, String expression) {
        List<String> operators = new ArrayList<>();
        List<Double> operands = new ArrayList<>();

        for (String token : tokens) {
            if (OPERATOR_PATTERN.matcher(token).matches()) {
                operators.add(token);
            } else {
                operands.add(Double.parseDouble(token));
            }
        }

        double result = getResult(operators, operands);

        String calculationExpression = expression.replaceAll("\\s+", "");
        addToCalculationHistory(calculationExpression + " = " + result);
        return result;
    }

    private double getResult(List<String> operators, List<Double> operands) {
        calculateOperations(operands, operators, "*", "/");
        calculateOperations(operands, operators, "+", "-");

        return operands.get(0);
    }

    private void calculateOperations(List<Double> operands, List<String> operators, String... targetOperators) {
        for (String targetOperator : targetOperators) {
            for (int i = 0; i < operators.size(); i++) {
                String operator = operators.get(i);
                if (operator.equals(targetOperator)) {
                    double operand1 = operands.get(i);
                    double operand2 = operands.get(i + 1);
                    double result = calculate(operand1, operand2, operator);

                    operands.set(i, result);
                    operands.remove(i + 1);
                    operators.remove(i);
                    i--;
                }
            }
        }
    }
}
