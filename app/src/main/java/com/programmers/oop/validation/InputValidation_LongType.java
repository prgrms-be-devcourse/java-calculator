package com.programmers.oop.validation;

import com.programmers.oop.utils.OperatorUtils;
import java.util.List;

import com.programmers.oop.message.ErrorMessage;
import com.programmers.oop.utils.ParserUtils;
import com.programmers.oop.utils.RegexUtils;

public class InputValidation_LongType implements Validation {

    /**
     * what : 식 입력의 유효성을 판단하는 메소드
     * how : 연산자(+,-,*,/)를 기반으로 split을 하고 해당 문자가 숫자로만 이루어져있는지 판단.
     * bug : 맨 앞과 뒷단에 연산자가 있어도 유효성 검증을 통과함..
     * worries : 반환타입을 boolean으로 if 문을 가져갈지, void로 가져가야할지.. 고민...
     * @param expression
     * @return
     */
    @Override
    public String verifyExpression(String expression) {
        List<String> expressionList = ParserUtils.splitOperator(expression);
        for (String exp : expressionList) {
            exp = exp.trim();
            if (exp.isBlank()) {
                // error : 잘못된 식 입력입니다.
                throw new RuntimeException(ErrorMessage.CLIENT_ERROR.toString());
            } else if (!RegexUtils.isNumericYn(exp)) {
                // error : 숫자 외 다른 문자가 포함되어있습니다.
                throw new RuntimeException(ErrorMessage.CLIENT_ERROR.toString());
            }
        }
        return expression;
    }

}
