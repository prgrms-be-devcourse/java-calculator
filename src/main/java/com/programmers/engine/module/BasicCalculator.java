package com.programmers.engine.module;

import com.programmers.engine.module.convert.AnswerConverter;
import com.programmers.engine.module.convert.PostfixConverter;
import java.util.List;

public class BasicCalculator {
    private final PostfixConverter postfixConverter = new PostfixConverter();
    private final AnswerConverter answerConverter = new AnswerConverter();

    public int doCalculate(String expression) {
        List<String> postfixList =  postfixConverter.convertInfixToPostfix(expression);
        return answerConverter.convertPostfixToAnswer(postfixList);
    }

}
