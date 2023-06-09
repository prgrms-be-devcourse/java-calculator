package calculator.view;

import calculator.domain.model.HistoryModel;
import calculator.domain.model.Message;

import java.util.List;

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

    public static void outputByCalculationResult(List<HistoryModel> historyModels){

        Message.calculationResultMessage(historyModels);
    }
}
