package calculator.io;

import static java.lang.System.*;

import java.util.List;
import java.util.Scanner;

public class IOManager implements Input, Output {

	private static final String FIND_ALL_ORDER_MESSAGE = "1. 조회";
	private static final String CALCULATE_ORDER_MESSAGE = "2. 계산";
	private static final String EXIT_ORDER_MESSAGE = "3. 종료";
	private static final String CHOICE_MESSAGE = "선택 : ";
	private static final String EXIT_MESSAGE = "종료!";
	private static final String FORMULA_MESSAGE = "수식을 입력해 주세요 : ";
	private static final String WRONG_ORDER_MESSAGE = "없는 명령 입니다!";
	private static final String DIVIDE_ZERO_MESSAGE = "0으로 나눌 수 없어요!";
	private static final String NO_DATA_MESSAGE = "실행된 계산이 없어요!";
	private static final String WRONG_FORMULA_MESSAGE = "잘못된 수식입니다!";
	private static final Scanner sc = new Scanner(in);

	@Override
	public String inputOrder() {
		return sc.nextLine();
	}

	@Override
	public String inputFormula() {
		out.print(FORMULA_MESSAGE);
		return sc.nextLine();
	}

	@Override
	public void requestInput() {
		out.println(FIND_ALL_ORDER_MESSAGE);
		out.println(CALCULATE_ORDER_MESSAGE);
		out.println(EXIT_ORDER_MESSAGE);
		out.println();
		out.print(CHOICE_MESSAGE);
	}

	@Override
	public void printAnswer(String result) {
		out.println(result);
		out.println();
	}

	@Override
	public void printFormulas(List<String> list) {
		for (String s : list) {
			out.println(s);
		}
		out.println();
	}

	@Override
	public void printExit() {
		out.println(EXIT_MESSAGE);
	}

	@Override
	public void printWrongOrder() {
		out.println(WRONG_ORDER_MESSAGE);
	}

	@Override
	public void printDivideZero() {
		out.println(DIVIDE_ZERO_MESSAGE);
	}

	@Override
	public void printNoData() {
		out.println(NO_DATA_MESSAGE);
	}

	@Override
	public void printWrongFormula() {
		out.println(WRONG_FORMULA_MESSAGE);
	}
}
