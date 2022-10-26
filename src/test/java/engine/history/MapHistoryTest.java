package engine.history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MapHistoryTest {

    @Test
    void saveTest() {
        MapHistory mapHistory = new MapHistory();

        mapHistory.save("1+1", "2");
        Assertions.assertEquals(mapHistory.getMap().size(), 1);

        mapHistory.save("2+2", "4");
        Assertions.assertEquals(mapHistory.getMap().size(), 2);

        String all = mapHistory.convertToString();
        System.out.println(all);
    }
}