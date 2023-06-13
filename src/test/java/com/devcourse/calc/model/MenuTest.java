package com.devcourse.calc.model;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.calc.converter.ConverterWithBracket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    private Calculator calculator = new Calculator(new CalcHistoryRepository(), new ConverterWithBracket());

    @Test
    @DisplayName("사용자의 입력 정보를 받아 메뉴 기능을 실행한다")
    void runMenuSuccess() {
        assertThat(Menu.find(1).execute(calculator)).isEqualTo("");
    }
}