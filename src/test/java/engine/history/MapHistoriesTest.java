package engine.history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MapHistoriesTest {

    @Test
    void saveTest() {
        MapHistories mapHistories = new MapHistories();

        mapHistories.save("1+1", "2");
        Assertions.assertEquals(mapHistories.getMap().size(), 1);

        mapHistories.save("2+2", "4");
        Assertions.assertEquals(mapHistories.getMap().size(), 2);

        String all = mapHistories.convertToString();
        System.out.println(all);
    }
}