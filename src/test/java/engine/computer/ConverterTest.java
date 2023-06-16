package engine.computer;

import com.devcourse.engine.model.accepter.Accepter;
import com.devcourse.engine.model.converter.Converter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class ConverterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1+1,11+", "1 + 2 * 5 -8/4,125*+84/-", " 1,1",
            "2. * 3,23*", "2.*3,23*", "1+2*(10-8)/4,12108-*4/+",
            "1.2*2,1.22*", "(1+2*(10-8))/4,12108-*+4/"
    })
    void convertTest(String input, String expected) {
        List<String> infixExperssions = new Accepter().accept(input);
        Converter converter = new Converter();

        String result = String.join("", converter.convert(infixExperssions));

        Assertions.assertEquals(expected, result);
    }

}
