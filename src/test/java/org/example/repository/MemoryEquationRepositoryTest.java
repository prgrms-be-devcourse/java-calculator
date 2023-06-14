package org.example.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryEquationRepositoryTest {
    private MemoryEquationRepository memoryRepository;

    @BeforeEach
    public void setupList(){
        memoryRepository = new MemoryEquationRepository();
    }

    @Test
    public void 계산값_1개_저장_후_조회(){
        memoryRepository.save("5 + 3 * 2", 11.0);
        String[] result = memoryRepository.findAll();
        assertThat(result[0]).isEqualTo("5 + 3 * 2 = 11.0");
    }

    @Test
    public void 계산값_2개_저장_후_조회(){
        memoryRepository.save("5 + 3 * 2", 11.0);
        memoryRepository.save("3 + 5 * 7", 38.0);
        String[] result = memoryRepository.findAll();
        assertThat(result[0]).isEqualTo("5 + 3 * 2 = 11.0");
        assertThat(result[1]).isEqualTo("3 + 5 * 7 = 38.0");
    }
}
