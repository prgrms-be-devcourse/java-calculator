package test.calculator.calculation;

import com.calculator.calculation.PostfixConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostfixConverterTest {

    @Test
    public void testConvertToPostfix() {
        PostfixConverter postfixConverter = new PostfixConverter();

        String expression = "1 + 2 * 3";
        String expectedPostfix = "[1, 2, 3, *, +]";

        postfixConverter.convertToPostfix(expression);
        ArrayList<String> actualPostfixArrayList = postfixConverter.getPostfix();

        StringBuilder sb = new StringBuilder();
        for(String str: actualPostfixArrayList){
            sb.append(str).append(" ");
        }
        String actualPostfix = sb.toString().trim();
        assertEquals(expectedPostfix, actualPostfix);
    }
}

