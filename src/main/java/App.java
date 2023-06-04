import controller.CalculatorApplication;
import exception.ErrorMessage;
import view.OutputView;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        //todo 연산 결과 저장소 생성

        //todo 계산기 생성

        CalculatorApplication ca = new CalculatorApplication(); //런타임 시점에 의존관계 주입
        try {
            ca.run();
        } catch (RuntimeException e) {
            if (e instanceof InputMismatchException) {
                OutputView.printErrorMessage(ErrorMessage.INVALID_CHAR);
            }
            else {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
