package com.programmers.oop.service;

import java.util.List;
import java.util.Stack;

import com.programmers.oop.repository.ComputeHistoryRepository;
import com.programmers.oop.type.Operator;
import com.programmers.oop.utils.OperatorUtils;
import com.programmers.oop.utils.ParserUtils;

public class Service implements ComputeService<String>, LookUpService<String> {

    private final ComputeHistoryRepository<String> respository;

    public Service(ComputeHistoryRepository respository) {
        this.respository = respository;
    }

    /**
     * @param formula := 계산식
     * @return := 계산 결과 값만 반환.
     */
    @Override
    public String computeExpression(String formula) {
        List<String> expressionList = ParserUtils.toPostFix(formula);
        String answer = computeFormula(expressionList);
        respository.save(formula + " = " + answer);
        return answer;
    }

    @Override
    public List<String> findByAll() {
        List<String> histories = respository.findAll();
        if (histories.isEmpty()) {
            return null;
        }
        return histories;
    }

    /**
     * worries : private 접근 제어자라.. test하기 용이하지 않는 단점이 있는데 어떤 역할로 분리해야할지 아이디어가 없습니다..
     *
     * @param expression
     * @return
     */

    private String computeFormula(List<String> expression) {
        StringBuilder answer = new StringBuilder();
        Stack<Long> stack = new Stack<>();
        for (String current : expression) {
            char ch = current.charAt(0);
            if (OperatorUtils.isProperOpertatorYn(ch)) {
                Operator operator = OperatorUtils.getOperator(ch);
                Long right = stack.pop();
                Long left = stack.pop();
                long result = operator.operate(left, right);
                stack.push(result);
            } else {
                stack.push(Long.parseLong(current));
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.toString();
    }


}
