import engine.repository.CalculatorRepository;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorRepositoryTest {

    private CalculatorRepository repository;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        repository = appConfig.calculatorRepository();
    }

    @Test
    public void saveFormulaTest() throws Exception {

        //given
        repository.save("3.9 * 9 / 3.0 + 2.02 = 13.72");
        repository.save("1 / 3.0 = 0.33");

        //when
        List<String> formula = repository.findAllValues();

        //then
        assertEquals(formula.size(), 2);
    }


}
