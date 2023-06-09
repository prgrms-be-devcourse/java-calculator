package calculator.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

import static calculator.global.ErrorResponse.INVALID_OPERAND;
import static calculator.global.ErrorResponse.OPERATOR_INPUT_ERROR;
import static calculator.global.Priority.HIGH;
import static calculator.global.Priority.LOW;

public class Operation {
    private static final Map<String, Operator> operatorMap = new HashMap<>();

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

    public Integer calculate(Integer a, String operator, Integer b){
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
        private final BiFunction<Integer, Integer, Integer> expression;
        private final Integer priority;

        Operator(String operator, BiFunction<Integer, Integer, Integer> expression, Integer priority) {
            this.operator = operator;
            this.expression = expression;
            this.priority = priority;
        }


        public boolean isSameOrGrater(Operator operator) {
            return priority >= operator.priority;
        }

        public Integer mapCalculate(String operator, Integer num1, Integer num2) {
            if(Operation.getOperator(operator) == DIVIDE && num2 <= 0){
                throw new ArithmeticException(INVALID_OPERAND);
            }
            return getOperator(operator).expression.apply(num1, num2);
        }
    }

}
