package com.programmers.engine;

import com.programmers.engine.model.storage.MapStorage;
import com.programmers.engine.model.storage.Storage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MapStorageTest {

    Storage storage = new MapStorage();

    @Test
    void 계산_결과_저장_및_조회_테스트() {
        String calculationCommand = "1 + 2";
        Integer calculationResult = 3;

        storage.save(calculationCommand, calculationResult);
        List<List<String>> searchResult = storage.findAll();

        Assertions.assertThat(searchResult.get(0)).containsExactly("1 + 2", "3");
    }
}