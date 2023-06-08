package com.devcourse.calc.model;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.calc.converter.ConverterWithBracket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {

    private Calculator calculator = new Calculator(new CalcHistoryRepository(), new ConverterWithBracket());

    @Test
    @DisplayName("사용자의 입력 정보를 받아 메뉴 기능을 실행한다")
    void runMenuSuccess() {
        assertThat(Menu.find(1).execute(calculator)).isEqualTo("");
    }

    @Test
    @DisplayName("없는 메뉴를 입력받아 기능 실행에 실패한다")
    void runMenuFail() {
        assertThatThrownBy(() -> Menu.find(3).execute(calculator))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("사용할 수 없는 메뉴 입니다");
    }

}