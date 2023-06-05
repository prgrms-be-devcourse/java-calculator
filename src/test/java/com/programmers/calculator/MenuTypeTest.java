package com.programmers.calculator;

import com.programmers.exception.WrongInputMenuException;
import com.programmers.io.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class MenuTypeTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void rightInputMenuNumber(String inputMenuNumber) {
        assertThatCode(
                () -> MenuType.findMenuType(inputMenuNumber)
        ).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "z", "4", "0", "!", ")"})
    void wrongInputMenuNumber(String inputMenuNumber) {
        assertThatThrownBy(() -> MenuType.findMenuType(inputMenuNumber))
                .isInstanceOf(WrongInputMenuException.class);
    }
}