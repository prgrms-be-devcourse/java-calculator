package org.devcourse.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class MemoryRepositoryTest {

    private final Repository repository = new MemoryRepository();

    @BeforeEach
    void save() {
        repository.save("1+4-10*(4+1) = -45");
        repository.save("10*(4+1) = 50");
    }

    @Test
    void findLatestHistory() {

        Assertions.assertThat(repository.findLatestHistory()).isEqualTo("10*(4+1) = 50");
    }

    @Test
    void findAll() {
        List<String> runHistory = repository.findAll();

        Assertions.assertThat(runHistory.size()).isEqualTo(2);
    }



}