package calculator.model.menu;

import calculator.model.menu.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

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
    void isNotValidMenuInput(String wrongMenuInput) {
        assertFalse(Menu.isValidMenuInput(wrongMenuInput));
    }

    @Test
    @DisplayName("Menu의 오버라이딩한 toString이 잘 작동하는지 테스트")
    void testToString() {
        List<String> menuStringExpected = List.of(
                "0. 종료",
                "1. 조회",
                "2. 계산"
        );


        List<String> menuList = Arrays.stream(Menu.values())
                .map(Menu::toString).toList();
        Assertions.assertThat(menuList)
                .hasSize(3)
                .contains("0. 종료")
                .contains("1. 조회")
                .contains("2. 계산")
                .isEqualTo(menuStringExpected);
    }
}