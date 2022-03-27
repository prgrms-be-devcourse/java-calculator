package repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.*;
class CalculatorRepositoryImplTest {

    CalculatorRepository repository = new CalculatorRepositoryImpl();

    @Test
    void 계산_결과_저장_성공() {
        //given
        String exp = "1+2-7";
        int result = -4;
        //when
        repository.save(exp,result);
        //then
        Assertions.assertThat(repository.getResult(exp)).isEqualTo(-4);
        Assertions.assertThat(repository.getResults().size()).isEqualTo(1);
    }

    @Test
    void 계산_결과_저장_실패() {
        //given
        String exp = "1+2-7";
        int result = -4;
        //when
        repository.save(exp,result);
        //then
        Assertions.assertThat(repository.getResult(exp)).isNotEqualTo(5);
    }

    @Test
    void 계산_결과_출력_성공() {
        //given
        String exp = "1+2-7";
        int result = -4;
        String exp2 = "3*2-2";
        int result2 = 4;
        //when
        repository.save(exp,result);
        repository.save(exp2,result2);
        //then
        Assertions.assertThat(repository.getResults().size()).isEqualTo(2);
    }
}