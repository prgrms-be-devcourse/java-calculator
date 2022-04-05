package calculator.module.validator;

import calculator.config.DependencyConfigurer;
import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionFactory;
import calculator.module.validator.exception.InvalidExpressionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CommonExpressionValidatorTest {
    CommonExpressionValidator validator = new CommonExpressionValidator();
    DependencyConfigurer dependencyConfigurer = new DependencyConfigurer();
    ExpressionFactory expressionFactory = dependencyConfigurer.createExpressionFactoryWithDependency();

    @ParameterizedTest
    @CsvFileSource(resources = "/invalid-expression-data.csv")
    void validatorTestWithIncorrectData(String input) throws InvalidExpressionException {
        Expression expression = expressionFactory.createExpression(input);
        Assertions.assertThrows(InvalidExpressionException.class,()-> validator.validateExpression(expression));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/valid-expression-data.csv")
    void validatorTestWithCorrectData(String input) throws InvalidExpressionException {
        Expression expression = expressionFactory.createExpression(input);
        Assertions.assertDoesNotThrow(()-> validator.validateExpression(expression));
    }

}