package calculator.engine.io;

import org.junit.jupiter.api.Test;

class SelectOptionTest {

    @Test
    void getLiterals_operation_test() {
        SelectOption.getLiterals().forEach(System.out::println);
    }
}