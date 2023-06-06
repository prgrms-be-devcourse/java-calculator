package calulator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calulator.domain.Menu.CALCULATED_LOG;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MenuTest {

    @DisplayName("메뉴 선택 정보를 반환한다.")
    @Test
    void menuInfoTest() {
        String info = Menu.menuInfo();

        assertThat(info).isEqualTo("1. 조회\n" +
                "2. 계산\n");
    }

    @DisplayName("사용자의 입력을 받아 선택 가능한 메뉴를 반환한다.")
    @Test
    void findMenuTest() {
        String input = "1";

        assertThat(Menu.valueOf(input)).isEqualTo(CALCULATED_LOG);
    }

    @DisplayName("선택지가 없는 메뉴를 선택시 예외를 발생한다.")
    @Test
    void findMenuFailTest() {
        String input = "";

        assertThat(Menu.of(input)).isNull();
    }

}
