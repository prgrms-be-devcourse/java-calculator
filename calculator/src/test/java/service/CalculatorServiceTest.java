package service;

import creator.CreatorManagement;
import creator.type.RepositoryType;
import entity.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.CalculatorRepository;

import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorService calcService = CreatorManagement.getCalcService();
    CalculatorRepository repository = CreatorManagement.createCalculatorRepository(RepositoryType.InMemory);

    @Test
    void getResultTest(){
        assertThat(calcService.getResult("1 + 9 * 3 / 3 - 1")).isEqualTo(9);
        assertThat(calcService.getResult("  -1 * 9 / -3  +   3    ")).isEqualTo(6);
    }

    @Test
    void getHistoriesSortedById(){

        for(int i = 0; i < 10; i++)
            repository.save("1 + 2", 3);

        AtomicLong id = new AtomicLong(1);

        calcService.getHistory()
                .stream()
                .iterator()
                .forEachRemaining(
                E -> Assertions.assertThat(E.getId()).isEqualTo(id.getAndIncrement())
        );



    }
}