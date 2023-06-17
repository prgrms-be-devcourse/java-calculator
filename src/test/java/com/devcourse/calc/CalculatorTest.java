package com.devcourse.calc;

import com.devcourse.calc.converter.ConverterNoBracket;
import com.devcourse.calc.model.CalculateRecord;
import com.devcourse.calc.model.History;
import com.devcourse.calc.model.Operand;
import com.devcourse.calc.model.Operator;
import com.devcourse.calc.repo.CalcHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;
    private CalcHistoryRepository repository;
    private ConverterNoBracket converter;

    @BeforeEach
    void init() {
        repository = new CalcHistoryRepository();
        converter = new ConverterNoBracket();
        calculator = new Calculator();
    }

    @Test
    @DisplayName("계산식 입력 시 결과 값을 반환한다 - History 타입")
    void calculateFormula() {
        int result = calculator.calculate(List.of(
                new Operand(11),
                new Operand(2),
                Operator.PLUS
        ));

        assertThat(result).isEqualTo(13);
    }

    @Test
    @DisplayName("계산 이력을 확인한다")
    void showAllHistory() {
        repository.saveHistory(new History("11 + 2", 13));
        repository.saveHistory(new History("11 + 3", 14));
        repository.saveHistory(new History("1 + 3", 4));

        CalculateRecord result = repository.getAllHistories();
        assertThat(result.toString()).isEqualTo("11 + 2 = 13\n11 + 3 = 14\n1 + 3 = 4");
    }
}