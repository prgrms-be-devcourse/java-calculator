package com.programmers.calculator.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

	@DisplayName("1. 메뉴 출력 테스트")
	@Test
	public void print_menu_test() throws Exception {
		String expected = "1. 조회\n2. 계산\n3. 초기화\n4. 종료\n";

		assertEquals(expected,Menu.menuList());
	}

	@DisplayName("2. 올바른 메뉴 입력인지 테스트")
	@Test
	public void fine_menu_test() throws Exception {
		assertEquals(Menu.INQUIRY, Menu.fineMenu("1"));
		assertEquals(Menu.CLEAR, Menu.fineMenu("3"));

		assertThrows(IllegalArgumentException.class, () -> {
			Menu.fineMenu("Q");
		});

	}

}
