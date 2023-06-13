package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2"})
    @DisplayName("올바른 메뉴 선택을 하였을 때 성공하는 테스트")
    void isValidMenu(String menuInput) {
        assertTrue(Menu.isValidMenuInput(menuInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "calculate", "no", " ", "\n"})
    @DisplayName("올바르지 메뉴 선택을 하였을 때 ")
    void isNotValidMenu(String wrongMenuInput) {
        assertFalse(Menu.isValidMenuInput(wrongMenuInput));
    }
}