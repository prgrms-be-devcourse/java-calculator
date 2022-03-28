package com.programmers.calculator.repository;

import com.programmers.calculator.vo.Formula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    private Repository<Formula> repository;

    @BeforeEach
    void setUp() {
        repository = new MemoryRepository();
    }

    @DisplayName("save() 테스트")
    @Nested
    class SaveFormula {
        @DisplayName("저장 가능 사례")
        @Test
        void saveSuccess() {
            final String[] one = new String[]{"1", "+", "2"};
            final Formula formula1 = new Formula(one, "3");
            Formula result = repository.save(formula1);
            assertEquals(formula1, result);
        }
    }

    @DisplayName("findAll() 테스트")
    @Nested
    class FindAllFormulas {
        @DisplayName("조회 가능 사례")
        @Test
        void findAllSuccess() {
            Formula formula1 = repository.save(new Formula(new String[]{"1", "+", "2"}, "3"));
            Formula formula2 = repository.save(new Formula(new String[]{"3", "*", "2"}, "6"));
            Formula formula3 = repository.save(new Formula(new String[]{"5", "-", "2"}, "3"));
            Formula[] list1 = repository.findAll().toArray(new Formula[0]);
            Formula[] list2 = new Formula[]{formula1, formula2, formula3};
            assertArrayEquals(list1, list2);
        }

        @DisplayName("조회 불가 사례")
        @Test
        void findAllFail() {
            assertEquals(repository.findAll(), new ArrayList<>());
        }
    }
}
