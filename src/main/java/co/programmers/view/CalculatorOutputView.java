package co.programmers.view;

public class CalculatorOutputView implements OutputView {

    public void print(String content) {
        System.out.println(">> 결과 : " + content);
    }

}
