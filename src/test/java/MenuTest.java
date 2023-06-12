import com.programmers.engine.model.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
public class MenuTest {
    @DisplayName("메뉴 선택 테스트")
    @Test
    void menuTest() {
        assertThat(Menu.matchMenu(1)).isEqualTo(Menu.LOOK_UP);
        assertThat(Menu.matchMenu(2)).isEqualTo(Menu.CALCULATE);
        assertThat(Menu.matchMenu(3)).isEqualTo(Menu.EXIT);
    }
}
