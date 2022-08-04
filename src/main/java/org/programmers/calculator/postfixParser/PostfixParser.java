package org.programmers.calculator.postfixParser;

import org.programmers.calculator.TypeChecker.TypeChecker;

import java.util.*;

/**
 * 입력받은 중위 표기법 식을 후위 표기법으로 변환해주는 역할을 한다.
 */
public abstract class PostfixParser {

    protected TypeChecker typeChecker;
    protected Map<String, Integer> operatorRank;

    protected final List<String> postfixExpression = new ArrayList<>();
    protected Deque<String> stack = new ArrayDeque<>();

    public PostfixParser(TypeChecker typeChecker) {
        this.typeChecker = typeChecker;
        operatorRank = typeChecker.getOperatorRank();
    }

    /**
     * 클라이언트가 외부에서 PostfixParser를 최초 호출하는 메서드이다.
     * @implSpec
     * 기본 구현의 경우 공백 " "을 기준으로 각 요소(연산자, 피연산자)를 구별하여 String[] 형태로
     * 실제 변환 작업을 수행하는 toPostfix로 전달한다.
     */
    public List<String> parse(String input) {
        clear();
        return toPostfix(input.split(" "));
    }

    public abstract List<String> toPostfix(String[] input);

    /**
     * @implNote
     * 변환에 사용하는 stack과 list를 비우는 역할을 한다.
     * 재정의해서 사용할 경우 재호출이 일어났을 때 이전 변환의 정보가 남아 있을 수 있음에 유의해야 한다.
     */
    protected void clear() {
        stack.clear();
        postfixExpression.clear();
    }
}
