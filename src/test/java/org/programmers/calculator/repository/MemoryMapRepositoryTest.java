package org.programmers.calculator.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("메모리 저장소 테스트")
public class MemoryMapRepositoryTest {

    @Test
    @DisplayName("키워드로 검색")
    void save() {
        MemoryMapRepository repository = new MemoryMapRepository();

        repository.save("1 + 2", "3");

        assertEquals("3",
                repository.findByKey("1 + 2"));
    }

    @Test
    @DisplayName("직전 저장 결과 검색")
    void findPrevious() {
        MemoryMapRepository repository = new MemoryMapRepository();

        repository.save("1 + 5", "6");
        String previousResult = repository.findPrevious();

        assertEquals("이전 계산입니다: 1 + 5 = 6", previousResult);
    }

    @Test
    @DisplayName("전체 저장 결과 검색")
    public void printAll() {
        MemoryMapRepository repository = new MemoryMapRepository();

        repository.save("1 + 3", "4");
        repository.save("5 * 2", "10");
        repository.save("8 / 2", "4");
        repository.save("-0.5 + 2 * 3", "5.5");

        List<String> result = repository.printAll();

        List<String> expected = new ArrayList<>();
        expected.add("1: 1 + 3 = 4");
        expected.add("2: 5 * 2 = 10");
        expected.add("3: 8 / 2 = 4");
        expected.add("4: -0.5 + 2 * 3 = 5.5");

        assertLinesMatch(expected, result);

    }
}
