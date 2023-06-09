package calculator.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

import static calculator.global.ErrorResponse.OPERATOR_INPUT_ERROR;
import static calculator.global.Priority.HIGH;
import static calculator.global.Priority.LOW;

public class Operation {
    private static Map<String, Operator> operatorMap = new HashMap<>();

    public Operation() {
        setOperatorMap();
    }

    private void setOperatorMap(){
        Arrays.stream(Operator.values())
                .forEach(op -> operatorMap.put(op.operator, op));
    }


    public Map<String, Operator> getOperatorMap() {
        return operatorMap;
    }

    public double calculate(double a, String operator, double b){
        return Optional.ofNullable(operatorMap.get(operator))
                .orElseThrow(() ->  new IllegalArgumentException(OPERATOR_INPUT_ERROR))
                .mapCalculate(operator,a,b);

    }
    public static Operator getOperator(String operator){
        return operatorMap.get(operator);
    }

    public enum Operator {

        PLUS("+", (num1, num2) -> num1 + num2, LOW),
        MINUS("-", (num1, num2) -> num1 - num2, LOW),
        MULTIPLY("*", (num1, num2) -> num1 * num2, HIGH),
        DIVIDE("/", (num1, num2) -> num1 / num2, HIGH);


        private final String operator;
        private final BiFunction<Double, Double, Double> expression;
        private final Integer priority;

        Operator(String operator, BiFunction<Double, Double, Double> expression, Integer priority) {
            this.operator = operator;
            this.expression = expression;
            this.priority = priority;
        }


        public boolean isSameOrGrater(Operator operator) {
            return priority >= operator.priority;
        }

        public double mapCalculate(String operator, double num1, double num2) {
            return getOperator(operator).expression.apply(num1, num2);
        }
    }

}
