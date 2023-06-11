package calculator.view;

import calculator.domain.model.HistoryModel;
import calculator.domain.model.Message;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void outputByMenu() {
        System.out.println(Message.MENU.getMessage());
    }

    public static void exitCalculator() {
        System.out.println(Message.EXIT.getMessage());
    }

    public static void outputByCalculationResult(HistoryModel historyModel){
        System.out.println(Message.calculationResult(historyModel));
    }

    public static void outputByCalculationResult(List<HistoryModel> historyModels){
        historyModels.forEach(OutputView::outputByCalculationResult);
    }
}