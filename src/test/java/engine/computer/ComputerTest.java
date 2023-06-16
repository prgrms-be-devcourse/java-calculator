package engine.computer;

import com.devcourse.engine.model.accepter.Accepter;
import com.devcourse.engine.model.computer.Computer;
import com.devcourse.engine.model.converter.Converter;
import com.devcourse.engine.model.exception.InvalidInputException;
import com.devcourse.engine.model.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class ComputerTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1+1,2.0", "1 + 2 * 5 -8/4,9.0", " 1,1.0",
            "2. * 3,6.0", "2.*3,6", "1+2*(10-8)/4,2",
            "1.2*2,2.4", "(1+2*(10-8))/4,1.25"
    })
    void computerTest(String input, double expected) {
        List<String> infixExperssions = new Accepter().accept(input);
        List<String> postfixExpressions = new Converter().convert(infixExperssions);
        Computer computer = new Computer();

        double result = computer.compute(postfixExpressions);

        Assertions.assertEquals(expected, result);
    }

}
