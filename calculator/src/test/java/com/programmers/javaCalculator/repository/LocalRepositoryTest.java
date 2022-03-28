package com.programmers.javaCalculator.repository;

import com.programmers.javaCalculator.domain.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LocalRepositoryTest {

    LocalRepository repository = new LocalRepository();

    @BeforeEach
    void clearRepository() {
        repository.clear();
    }

    @Test
    @DisplayName("로컬 레포지토리에 유효한 중위식 저장")
    void save() {
        Expression ex1 = new Expression("1 + 3 * 2", "7");

        repository.save(ex1);

        Expression ex2 = repository.findAll().get(0);

        assertThat(ex2.toString()).isEqualTo(ex1.toString());
    }

    @Test
    @DisplayName("로컬 레포지토리에 저장된 모든 중위식을 반환")
    void findAll() {
        List<Expression> list = new ArrayList<>();

        Expression ex1 = new Expression("1 + 3 * 2", "7");
        Expression ex2 = new Expression("5 - 2", "3");
        Expression ex3 = new Expression("5 / 2", "2");

        list.add(ex1);
        list.add(ex3);
        list.add(ex2);

        repository.save(ex1);
        repository.save(ex3);
        repository.save(ex2);

        List<Expression> allRepo = repository.findAll();

        for (int i = 0; i < allRepo.size(); i++)
            assertThat(list.get(i).toString()).isEqualTo(allRepo.get(i).toString());
    }

}