package calculator.module.arithmetic;

import calculator.config.DependencyConfigurer;
import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionFactory;
import calculator.module.validator.exception.InvalidExpressionException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class StackArithmeticModuleTest {
    StackArithmeticModule arithmeticModule = new StackArithmeticModule();
    DependencyConfigurer dependencyConfigurer = new DependencyConfigurer();
    ExpressionFactory expressionFactory = dependencyConfigurer.createExpressionFactoryWithDependency();

    @ParameterizedTest
    @CsvFileSource(resources = "/arithmetic_module-test-data.csv",delimiter = '=')
    void calculateTest(String input,Double answer) throws InvalidExpressionException {
        Expression expression = expressionFactory.createExpression(input);
        double calculationResult = arithmeticModule.calculate(expression);
        Assertions.assertThat(calculationResult).isEqualTo(answer);
    }


}