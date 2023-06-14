import main.java.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    @DisplayName("선택 메뉴를 제외한, 화면에 출력될 메뉴의 갯수를 테스트.")
    @Test
    public void menuCountTest() {
        assertEquals(3, Menu.menuCount);
    }
}
