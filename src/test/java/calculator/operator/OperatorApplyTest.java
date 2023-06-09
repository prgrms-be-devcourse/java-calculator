package calculator.operator;

import calculator.model.Operation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorApplyTest {
    @Test
    @DisplayName("사칙 연산 Map 테스트")
    void confirm(){
        Operation operation = new Operation();

        int a = 10;
        int b = -5;


    operation.getOperatorMap().entrySet()
            .forEach(e -> {
                System.out.print(a + e.getKey() + b + " = ");
                System.out.println(operation.calculate(a, e.getKey(), b));
            });
    }

}
