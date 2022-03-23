package hyuk;

import hyuk.entity.Operands;
import hyuk.entity.Operators;
import hyuk.entity.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemoryRepositoryTest {

    @DisplayName("계산이력 저장 기능 테스트")
    @Test
    void store() {
        //given
        MemoryRepository memoryRepository = new MemoryRepository();

        String exp = "1 + 2 * 3 + 4";
        Operands operands = new Operands(exp);
        Operators operators = new Operators(exp);

        Calculator calculator = new Calculator();
        Result result = calculator.calculate(operands, operators);

        //when
        memoryRepository.store(operands, operators, result);

        //then
        Assertions.assertThat(memoryRepository.getData())
            .contains(exp + " = " + result.getResult());
    }

}
