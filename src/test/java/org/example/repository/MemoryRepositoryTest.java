package org.example.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryRepositoryTest {
    private MemoryRepository memoryRepository;

    @BeforeEach
    public void setupList(){
        memoryRepository = new MemoryRepository();
    }

    @Test
    public void 계산값_1개_저장_후_조회(){
        memoryRepository.save("5 + 3 * 2 = 11");
        String[] result = memoryRepository.findAll();
        assertThat(result[0]).isEqualTo("5 + 3 * 2 = 11");
    }

    @Test
    public void 계산값_2개_저장_후_조회(){
        memoryRepository.save("5 + 3 * 2 = 11");
        memoryRepository.save("3 + 5 * 7 = 38");
        String[] result = memoryRepository.findAll();
        assertThat(result[0]).isEqualTo("5 + 3 * 2 = 11");
        assertThat(result[1]).isEqualTo("3 + 5 * 7 = 38");
    }
}
