package calculator.module.arithmetic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

class PrefixConverterTest {
    private final PrefixConverter converter = new PrefixConverter();

    @ParameterizedTest
    @CsvFileSource(resources = "/prefix_converter-test-data.csv",delimiter = '=')
    void convertPrefixTest(String expression,String expected){
        List<String> result = converter.convertExpressionToPrefix(expression);
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        Assertions.assertThat(sb.toString()).isEqualTo(expected);
    }

}