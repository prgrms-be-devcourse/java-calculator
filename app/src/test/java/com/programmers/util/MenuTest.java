package com.programmers.util;

import com.programmers.exception.NotFoundMenuException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class MenuTest {
	
	@ParameterizedTest
	@DisplayName("올바른 입력을 할 경우 해당되는 메뉴를 반환한다.")
	@CsvSource(value = {"1 VIEW", "2 CALCULATE", "3 EXIT"}, delimiter = ' ')
	void correctMenu(String select, Menu menu) {
		assertThat(Menu.of(select))
				.isEqualTo(menu);
	}
	
	@Test
	@DisplayName("선택지에 없는 숫자를 입력하면 NotFoundMenuException을 던진다.")
	void throwNotFoundMenuException() {
		// given
		String select = "4";
		
		// then
		assertThatThrownBy(() -> {
			Menu.of(select);
		}).isExactlyInstanceOf(NotFoundMenuException.class)
		  .hasMessage("메뉴에서 없는 선택지입니다.");
	}
	
}