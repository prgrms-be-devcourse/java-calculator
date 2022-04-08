import Calculator.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @Test
    @DisplayName("문자열 1로 RECORD 메뉴얼을 가져온다")
    public void _1() {
        String s = "1";
        Menu menu = Menu.getManual(s);
        assertThat(menu).isEqualTo(Menu.RECORD);
    }

    @Test
    @DisplayName("문자열 2로 calc 메뉴얼을 가져온다")
    public void _2() {
        String s = "2";
        Menu menu = Menu.getManual(s);
        assertThat(menu).isEqualTo(Menu.CALC);
    }

    @Test

    @DisplayName("문자열 3로 exit 메뉴얼을 가져온다")
    public void _4() {
        String s = "3";
        Menu menu = Menu.getManual(s);
        assertThat(menu).isEqualTo(Menu.EXIT);
    }
}