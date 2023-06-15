package co.programmers.view;

import java.util.Map;

public class CalculatorOutputView implements OutputView {
	public static void printCalculationGuide() {
		System.out.println("1 + 2 * 3와 같은 형식으로 계산하고자 하는 식을 입력하세요.");
		System.out.print("> ");
	}

	public static void printMenuChoiceGuide() {
		System.out.println("\n[다음 중 원하시는 항목을 숫자로 입력하세요]");
		System.out.println("1. 조회");
		System.out.println("2. 계산");
		System.out.println("3. 종료");
		System.out.print("> 선택 :  ");
	}

	@Override
	public void printCalculationResult(Double result) {
		System.out.println(">> 결과 : " + result);
	}

	@Override
	public void printMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void printCalculationHistory(Map<String, Double> history) {
		System.out.println(">> 계산 기록 조회");
		for (Map.Entry<String, Double> oneExpression : history.entrySet()) {
			System.out.println(oneExpression.getKey() + " = " + oneExpression.getValue());
		}
	}
}
