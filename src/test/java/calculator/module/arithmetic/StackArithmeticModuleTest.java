package calculator.module.arithmetic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StackArithmeticModuleTest {
    StackArithmeticModule arithmeticModule = new StackArithmeticModule();
    @ParameterizedTest
    @CsvFileSource(resources = "/arithmetic-module-test-data.csv",delimiter = '=')
    void calculateTest(String expression,double answer) {
        double calculationResult = arithmeticModule.calculate(expression);
        Assertions.assertThat(calculationResult).isEqualTo(answer);
    }


}