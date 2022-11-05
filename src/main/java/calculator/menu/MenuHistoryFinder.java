package calculator.menu;

import calculator.calculator.history.CalculationHistory;
import calculator.calculator.history.History;
import calculator.view.output.MenuHistoryOutput;

public class MenuHistoryFinder implements Menu {

    private final History calculationHistory;
    private final MenuHistoryOutput output;

    public MenuHistoryFinder() {
        this.calculationHistory = new CalculationHistory();
        this.output = new MenuHistoryOutput();
    }

    @Override
    public void process() {
        output.printHistories(
                calculationHistory.findAllHistories());
    }
}
