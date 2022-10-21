package calculator.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WriterTest {

    @DisplayName("선택 옵션 출력 테스트")
    @Test
    void test1() {
        new Writer().printSelectOption(SelectOption.getLiterals());
    }
}