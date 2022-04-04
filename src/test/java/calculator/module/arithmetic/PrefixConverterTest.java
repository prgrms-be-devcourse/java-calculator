package calculator.module.arithmetic;

import calculator.DependencyConfigurer;
import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionFactory;
import calculator.model.expression.ExpressionableToken;
import calculator.module.validator.exception.InvalidExpressionException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

class PrefixConverterTest {
    private final PrefixConverter converter = new PrefixConverter();
    DependencyConfigurer dependencyConfigurer = new DependencyConfigurer();
    ExpressionFactory expressionFactory = dependencyConfigurer.expressionFactory();

    @ParameterizedTest
    @CsvFileSource(resources = "/prefix_converter-test-data.csv",delimiter = '=')
    void convertPrefixTest(String input,String expected) throws InvalidExpressionException {
        Expression expression = expressionFactory.createExpression(input);
        List<ExpressionableToken> result = converter.convertExpressionToPrefix(expression.getTokenArray());

        StringBuilder sb = new StringBuilder();
        for (ExpressionableToken s : result) {
            sb.append(s.getValue());
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        Assertions.assertThat(sb.toString()).isEqualTo(expected);
    }
}