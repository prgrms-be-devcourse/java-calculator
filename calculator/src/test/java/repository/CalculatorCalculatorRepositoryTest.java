package repository;

import entity.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorCalculatorRepositoryTest {

    CalculatorRepository calculatorRepository;

    @BeforeEach
    void setRepository(){
        calculatorRepository = new InMemoryRepository();
    }

    @Test
    void saveHistory(){

        String input = "1 + 2";
        double result = 3;

        Long id = 1L;

        Expression expression1 = new Expression(id,input,result);
        Expression expression2 = calculatorRepository.save(input,result);
        assertThat(expression1.equals(expression2)).isEqualTo(true);
    }

    @Test
    void findAllWhenHistoryNull(){
        assertThat(calculatorRepository.findAll().size()).isEqualTo(0);
    }
}