package calculator.validation;

import java.util.Arrays;

public class ValidationImpl implements Validation{
    @Override
    public boolean isOperator(String str) {
        String[] operators = {"+","-","*","/"};
        return Arrays.asList(operators).contains(str);
    }

    @Override
    public boolean divideByZero(String operator,double number) {
        if(!operator.equals("/")) return true;
        if(number == 0.0) return false;
        return true;
    }
}
