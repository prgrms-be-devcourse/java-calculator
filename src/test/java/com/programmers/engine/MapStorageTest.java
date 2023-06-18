package com.programmers.engine;

import com.programmers.engine.model.storage.MapStorage;
import com.programmers.engine.model.storage.Storage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MapStorageTest {

    public static final String CALCULATION_COMMAND = "1 + 2";
    public static final Integer CALCULATION_RESULT = 3;
    Storage storage = new MapStorage();

    @Test
    void 계산_결과_저장_및_조회_테스트() {

        storage.save(CALCULATION_COMMAND, CALCULATION_RESULT);
        List<List<String>> searchResult = storage.findAll();

        Assertions.assertThat(searchResult.get(0))
                .containsExactly(CALCULATION_COMMAND, CALCULATION_RESULT+"");
    }
}