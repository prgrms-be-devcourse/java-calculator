package engine.computer;

import com.devcourse.engine.model.converter.PostfixConverter;
import com.devcourse.engine.model.validator.ExpressionValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConverterTest {

    @Test
    void convertTest1() {
        Validator validator = new ExpressionValidator();
        Converter converter = new PostfixConverter();
        List<String> result = converter.convert(validator.validate("1+1"));
        Assertions.assertEquals(result.size(), result.size());
    }

    @Test
    void convertTest2() {
        Validator validator = new ExpressionValidator();
        Converter converter = new PostfixConverter();
        List<String> result = converter.convert(validator.validate("1 + 2* 5 - 8/4"));
        Assertions.assertEquals(result.size(), result.size());
    }

    @Test
    void convertTest3() {
        Validator validator = new ExpressionValidator();
        Converter converter = new PostfixConverter();
        List<String> result = converter.convert(validator.validate("1+2*(10-8)/4"));
        System.out.println(result);
        Assertions.assertEquals(9, result.size());
    }

    @Test
    void convertTest4() {
        Validator validator = new ExpressionValidator();
        Converter converter = new PostfixConverter();
        List<String> result = converter.convert(validator.validate("(1+2*(10-8))/4"));
        Assertions.assertEquals("12108-*+4/", String.join("", result));
    }

}
