package calculator.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListRepositoryTest {

    CalculationRepository listRepository = new ListRepository();

    @Test
    public void 저장_테스트() throws Exception {
        //given
        for (int i = 0; i < 10; i++) {
            listRepository.save(i +" + 10", Double.valueOf(i + 10));
        }
        //when
        List<String> all = listRepository.findAll();
        // all.forEach((s) -> System.out.println(s));
        //then
        Assertions.assertEquals(10, all.size());
    }

}