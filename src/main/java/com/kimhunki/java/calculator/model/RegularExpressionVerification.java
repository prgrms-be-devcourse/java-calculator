package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.strategy.VerificationStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.kimhunki.java.calculator.model.RegularExpressionPattern.*;

public class RegularExpressionVerification implements VerificationStrategy {
    // 민성님 코드를 참고했습니다.

    public boolean verify(String expression) {
        int tokenCnt = 0;
        boolean flag = false;
        if (!acceptablePattern.matcher(expression).matches()) return true;// 일단 이상한 부호 들어가면
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            String group = matcher.group();
            if (isNumberInWrongPosition(tokenCnt, group) || isOperatorInWrongPosition(tokenCnt, group)) flag = true;
            tokenCnt++;

        }
        //        System.out.println(flag);
        if (isAppropriateTokenCount(tokenCnt)) flag = true;
        return flag;
    }

    private boolean isAppropriateTokenCount(int tokenCount) {
        return tokenCount == 1 || tokenCount % 2 == 0;
    }

    private boolean isOperatorInWrongPosition(int tokenCount, String group) {
        return tokenCount % 2 != 0 && !operatorPattern.matcher(group).matches();
    }

    private boolean isNumberInWrongPosition(int tokenCount, String group) {
        return tokenCount % 2 == 0 && !numberPattern.matcher(group).matches();
    }

}
