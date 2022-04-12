package com.programmers.mission.model;

public enum MenuType {
	LOOK_UP("1"), CALCULATE("2"), EXIT("3");

	private String key;

	MenuType(String key) {
		this.key = key;
	}

	public boolean isService(String menu) {
		return key.equals(menu);
	}

}
