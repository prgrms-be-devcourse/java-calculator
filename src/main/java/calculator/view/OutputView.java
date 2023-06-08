package calculator.view;

import calculator.domain.model.HistoryModel;
import calculator.domain.model.Message;

public class OutputView {

    private OutputView() {
    }

    public static void outputByMenu() {

        Message.menuMessage();
    }

    public static void exitCalculator() {

        Message.exitMessage();
    }

    public static void outputByCalculationResult(HistoryModel historyModel){

        Message.calculationResultMessage(historyModel);
    }
}
