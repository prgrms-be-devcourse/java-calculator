package repository;

import entity.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class CalculatorMemoryRepositoryTest {

    MemoryRepository memoryRepository;

    @BeforeEach
    void setRepository(){
        memoryRepository = new CalculatorRepository();
    }

    @Test
    void saveHistory(){

        String input = "1 + 2";
        double result = 3;

        Long id = 1L;

        Expression expression1 = new Expression(id,input,result);
        Expression expression2 = memoryRepository.save(input,result);
        assertThat(expression1.equals(expression2)).isEqualTo(true);
    }

    @Test
    void findAllWhenHistoryNull(){
        assertThat(memoryRepository.findAll().size()).isEqualTo(0);
    }
}