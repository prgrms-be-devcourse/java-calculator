package engine.compute.operate;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;

public class OperateMachine {
    private final ExpressionValidator validator;
    private static final String NUMBER_FORMAT = "0.00";
    public OperateMachine(ExpressionValidator validator) {
        this.validator = validator;
    }

    public String doCalculate(List<Token> postFix) {
        Stack<Double> st = new Stack<>();

        for (Token token : postFix) {
            if (validator.isNumber(token)) {
                double storedValue = Double.parseDouble(token.getToken());
                st.push(storedValue);

            }
            if (validator.isOperator(token)) {
                double num1 = st.pop();
                double num2 = st.pop();

                Operator operator = Operator.getOperator(token.getToken());
                double result = operator.calculate(num2, num1);

                st.push(result);
            }
        }
        return formatReturnString(st.pop());
    }

    //소수점 두자리까지만 출력
    private String formatReturnString(double num) {
        DecimalFormat df = new DecimalFormat(NUMBER_FORMAT);
        return df.format(num);
    }
}
