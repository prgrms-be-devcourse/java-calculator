package engine.operate;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;

public class OperateMachine {
    private ExpressionValidator validator;

    public OperateMachine(ExpressionValidator validator) {
        this.validator = validator;
    }

    public String doCalculate(List<Token> postFix) {
        Stack<Double> st = new Stack<>();

        for (Token token : postFix) {
            if (validator.isNumber(token)) {
                double d = Double.parseDouble(token.getToken());
                st.push(d);

            }
            if (validator.isOperator(token)) {
                double num1 = st.pop();
                double num2 = st.pop();

                Operator operator = Operator.getOperator(token.getToken());
                double result = operator.calculate(num2, num1);

                st.push(result);
            }
        }
        return numberFormatting(st.pop());
    }

    //소수점 두자리까지만 출력
    private String numberFormatting(double num) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num);
    }
}
