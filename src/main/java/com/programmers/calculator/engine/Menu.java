package com.programmers.calculator.engine;

import java.util.Objects;
import java.util.stream.Stream;

import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.service.CalculateService;
import com.programmers.calculator.engine.service.CalculatorService;
import com.programmers.calculator.engine.service.ClearService;
import com.programmers.calculator.engine.service.InquiryService;

public enum Menu {
	INQUIRY("1", "1. 조회", new InquiryService()),
	CALCULATE("2", "2. 계산", new CalculateService()),
	CLEAR("3", "3. 초기화", new ClearService()),
	QUIT("4", "4. 종료", null);

	private String button;
	private String menu;
	private CalculatorService service;

	Menu(String button, String menu, CalculatorService service) {
		this.button = button;
		this.menu = menu;
		this.service = service;
	}

	public static String menuList() {
		StringBuilder str = new StringBuilder();
		Stream.of(Menu.values()).map(m -> m.menu)
			.forEach(s -> str.append(s + "\n"));

		return str.toString();
	}

	public static Menu fineMenu(String buttonName) {
		return Stream.of(Menu.values()).filter(m ->
			m.button.equals(buttonName))
			.findAny()
			.orElseThrow(() ->
				new IllegalArgumentException("[ERROR] 잘못된 메뉴 입력입니다."));
	}

	public boolean isRunning() {
		if (!Objects.equals(this, QUIT)) {
			return true;
		}
		return false;
	}

	public static Menu setRunningState() {
		return CLEAR;
	}

	public String start(CalculatorRepository repository, String formula) {
		Objects.requireNonNull(repository);
		Objects.requireNonNull(formula);

		return this.service.execute(repository, formula);
	}
}
