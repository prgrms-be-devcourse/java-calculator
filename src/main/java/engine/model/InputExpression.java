package engine.model;

import java.util.List;

// 사용자가 입력한 연산 식을 저장하는 클래스
public class InputExpression {
    private List<String> inputExpression;

    public InputExpression(List<String> inputExpression) {
        this.inputExpression = inputExpression;
    }
}
