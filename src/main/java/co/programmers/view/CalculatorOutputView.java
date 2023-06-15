package co.programmers.view;

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

    public void printCalculationRes(Integer content) {
        System.out.println(">> 결과 : " + content);
    }
}
