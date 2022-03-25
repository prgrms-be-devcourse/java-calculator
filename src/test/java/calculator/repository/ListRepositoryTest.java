package calculator.repository;

import calculator.engine.model.CalculationDto;
import org.junit.jupiter.api.Test;

import java.util.List;

class ListRepositoryTest {

    ListRepository listRepository = new ListRepository();

    @Test
    public void 저장_테스트() throws Exception {
        //given
        for (int i = 0; i < 10; i++) {
            CalculationDto calculationDto
                    = new CalculationDto(i +" + 10", Double.valueOf(i + 10));
            listRepository.save(calculationDto);
        }
        //when
        List<String> all = listRepository.findAll();
        all.forEach((s) -> System.out.println(s));
        //then
    }

}