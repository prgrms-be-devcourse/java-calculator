import controller.CalculatorApplication;
import exception.ErrorMessage;
import model.Calculator;
import model.CalculatorImpl;
import repository.CalculateLogRepository;
import repository.CalculateLogRepositoryImpl;
import view.OutputView;

import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) {
        Calculator calculator =  new CalculatorImpl();
        CalculateLogRepository repository =  new CalculateLogRepositoryImpl();

        CalculatorApplication app = new CalculatorApplication(calculator, repository); //런타임 시점에 의존관계 주입
        try {
            app.run();
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                OutputView.printErrorMessage(ErrorMessage.INVALID_CHAR);
            }
            else {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
