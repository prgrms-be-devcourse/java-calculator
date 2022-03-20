package com.prgrms.ndy.parsor;


import com.prgrms.ndy.domain.Command;

public abstract class Parser {

    protected abstract void checkIsValidExpression(String in);

    protected abstract Command parseLogic(String expression);

    /**
     * @param in 계산식
     * @return 파싱결과
     * @throws IllegalArgumentException 파싱에 실패하는 경우
     */
    public Command parse(String in) {
        String expr = in.replace(" ", "");
        checkIsValidExpression(expr);
        return parseLogic(expr);
    }


}
