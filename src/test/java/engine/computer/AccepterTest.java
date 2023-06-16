package engine.computer;

import com.devcourse.engine.model.accepter.Accepter;
import com.devcourse.engine.model.validator.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AccepterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1+1,3", "1 + 2 * 5 -8/4,9", " 1,1",
            "2. * 3,3", "2.*3,3", "1+2*(10-8)/4,11",
            "1.2*2,3", "(1+2*(10-8))/4,13"
    })
    void acceptTest(String input, int expected) {
        Accepter accepter = new Accepter();
        int result = accepter.accept(input).size();
        Assertions.assertEquals(expected, result);
    }

}
