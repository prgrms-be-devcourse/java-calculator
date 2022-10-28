package engine.history;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MapHistoriesTest {

    @Test
    void saveTest1() {
        //given
        MapHistories mapHistories = new MapHistories();

        //when
        mapHistories.save("1+1", "2");

        //then
        Assertions.assertEquals(1, mapHistories.getHistories().size());
    }

    @Test
    void saveTest2() {
        MapHistories mapHistories = new MapHistories();

        mapHistories.save("1+1", "2");
        mapHistories.save("2+2", "4");

        Assertions.assertEquals(2, mapHistories.getHistories().size());
    }
}