import main.java.domain.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuTest {

    @Test
    public void menuCountTest() {
        assertEquals(3, Menu.menuCount);
    }
}
