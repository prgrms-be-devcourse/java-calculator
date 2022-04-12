package com.programmers.mission.model;

import java.util.Arrays;

import com.programmers.mission.exception.NotSupportedMenuException;
import com.programmers.mission.message.ErrorMessage;

public enum MenuType {
	LOOK_UP("1"), CALCULATE("2"), EXIT("3");

	private String key;

	MenuType(String key) {
		this.key = key;
	}

	public boolean isService(String menu) {
		return key.equals(menu);
	}

	public static MenuType getMenuType(String menu) {
		return Arrays.stream(MenuType.values())
				.filter(menuType -> menuType.isService(menu))
				.findAny()
				.orElseThrow(() -> new NotSupportedMenuException(ErrorMessage.CLIENT_ERROR));
	}

}
