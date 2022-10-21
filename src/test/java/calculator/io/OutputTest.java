package calculator.io;

import calculator.engine.io.Output;
import calculator.engine.io.SelectOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {

    @DisplayName("선택 옵션 출력 테스트")
    @Test
    void test1() {
        new Output().printSelectOption(SelectOption.getLiterals());
    }
}