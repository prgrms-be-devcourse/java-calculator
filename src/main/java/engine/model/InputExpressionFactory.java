package engine.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputExpressionFactory {

    public InputExpression createInputExpression(String input) {
        //사용자의 input을 InputExpression으로 전환한다.
        List<String> list = new ArrayList<>();
        Arrays.stream(input.split(" ")).map(i -> list.add(i));

        return new InputExpression(list);
    }
}
