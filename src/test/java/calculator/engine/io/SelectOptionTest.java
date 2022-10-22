package calculator.engine.io;

import calculator.engine.io.enums.SelectOption;
import org.junit.jupiter.api.Test;

class SelectOptionTest {

    @Test
    void getLiterals_operation_test() {
        SelectOption.getLiterals().forEach(System.out::println);
    }
}