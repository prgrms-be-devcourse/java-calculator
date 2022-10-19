package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTypeTest {

    @DisplayName("from은 알맞은 메뉴값를 주면 MenuType을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void from_menu_returnType(String menu) {
        assertThat(MenuType.from(menu))
            .isInstanceOf(MenuType.class);
    }

    @DisplayName("from은 알맞은 메뉴값이 아닐 때 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", " ", "//", "5", "100", "ㅁ"})
    void from_notOperand_throwException(String notMenu) {
        assertThatThrownBy(() -> MenuType.from(notMenu))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("\n[ERROR] 1, 2, 3번 중 선택하세요.\n");
    }

    @DisplayName("from은 공백이거나 null이면 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void from_NullAndEmpty_throwException(String notMenu) {
        assertThatThrownBy(() -> MenuType.from(notMenu))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("\n[ERROR] 1, 2, 3번 중 선택하세요.\n");
    }
}
