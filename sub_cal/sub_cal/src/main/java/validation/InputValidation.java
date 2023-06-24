package validation;

import option.Option;

import java.util.Optional;

public class InputValidation {
    public static boolean isValidMenuNumber(Optional<Option> userOption){
        if(userOption.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isEmptyInputExpression(String expression){
        if(expression.isBlank()){
            return true;
        }
        return false;
    }



}
