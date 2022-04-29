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

	/**
	 * 메뉴 리스트를 String으로 반환해 주는 메서드
	 *
	 * @return 메뉴 리스트
	 */
	public static String menuList() {
		StringBuilder str = new StringBuilder();
		Stream.of(Menu.values()).map(m -> m.menu)
			.forEach(s -> str.append(s + "\n"));

		return str.toString();
	}

	/**
	 * 올바른 메뉴 버튼 입력인지 유효성 검사를 실시하고 해당하는 메뉴를 반환하는 메서드
	 *
	 * @param buttonName
	 * @return 입력된 buttonName에 해당하는 Menu
	 * @throws IllegalArgumentException 잘못된 메뉴 버튼을 입력하면 IllegalArgumentException 반환
	 */
	public static Menu fineMenu(String buttonName) {
		return Stream.of(Menu.values()).filter(m ->
			m.button.equals(buttonName))
			.findAny()
			.orElseThrow(() ->
				new IllegalArgumentException("[ERROR] 잘못된 메뉴 입력입니다."));
	}

	/**
	 * 현재 프로그램이 진행중인지 판단하는 메서드
	 *
	 * @return 만약 QUIT 이면 false, 아니면 true
	 */
	public boolean isRunning() {
		if (!Objects.equals(this, QUIT)) {
			return true;
		}
		return false;
	}

	/**
	 * 처음 Menu를 초기화하는 메서드
	 *
	 * @return CLEAR 메뉴
	 */
	public static Menu setRunningState() {
		return CLEAR;
	}

	/**
	 * 메뉴에 해당하는 service를 호출하는 메서드
	 *
	 * @param repository
	 * @param formula
	 * @return 메뉴에 해당하는 service를 실행하고 난 뒤 결과를 반환
	 */
	public String start(CalculatorRepository repository, String formula) {
		Objects.requireNonNull(repository);
		Objects.requireNonNull(formula);

		return this.service.execute(repository, formula);
	}
}
