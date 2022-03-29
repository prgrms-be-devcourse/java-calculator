package repository;

import entity.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.*;

class ExpressionRepositoryTest {

    Repository repository;

    @BeforeEach
    void setRepository(){
        repository = ExpressionRepository.getInstance();
    }

    @Test
    @DisplayName("저장소가 싱글톤을 보장해주는지")
    void checkSingleton(){
        Repository repository2 = ExpressionRepository.getInstance();

        String input = "1 + 2";
        double result = 3;

        repository2.save(input,result);
        Expression expression = new Expression(input,result);

        Assertions.assertThat(expression).isEqualTo(repository.findAll().get(0));

    }

    @Test
    @DisplayName("저장이 올바르게 되었는지")
    void saveHistory(){

        String input = "1 + 2";
        double result = 3;

        repository.save(input,result);
        List<Expression> histories = repository.findAll();

        Assertions.assertThat(new Expression(input,result)).isEqualTo(histories.get(0));
    }

    @Test
    @DisplayName("연산 이력이 없는데 조회하고 있지 않은지")
    void findAllWhenHistoryEmpty(){
        assertThat(repository.findAll().size()).isEqualTo(0);
    }
}