package com.programmers.calculator.engine;

import java.util.Objects;
import java.util.stream.Stream;

public enum Menu {
	INQUIRY("1","1. 조회"),
	CALCULATE("2","2. 계산"),
	CLEAR("3","3. 초기화"),
	QUIT("4","4. 종료");

	private String button;
	private String menu;

	Menu(String button, String menu) {
		this.button = button;
		this.menu = menu;
	}

	public static String menuList(){
		StringBuilder str = new StringBuilder();
		Stream.of(Menu.values()).map(m -> m.menu)
			.forEach(s -> str.append(s +  "\n"));

		return str.toString();
	}

	public static Menu fineMenu(String buttonName){
		return Stream.of(Menu.values()).filter(m ->
			m.button.equals(buttonName))
			.findAny()
			.orElseThrow(() ->
				new IllegalArgumentException("[ERROR] 잘못된 메뉴 입력입니다."));
	}

	public boolean isRunning(){
		if(!Objects.equals(this,QUIT)){
			return true;
		}
		return false;
	}

	public static Menu setRunningState(){
		return CLEAR;
	}
}
