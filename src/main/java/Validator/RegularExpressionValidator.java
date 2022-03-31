package Validator;

public class RegularExpressionValidator implements Validator {

    @Override
    public boolean validate(String expression) {
        return expression.matches(RegularExpressionType.REGULAR_EXPRESSION_TYPE.getRegExp());
    }

}
