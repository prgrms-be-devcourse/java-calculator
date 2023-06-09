package model.menu;

import exception.CalculatorException;
import repository.CalculationLogRepository;

public abstract class SelectMenuExecutor {
    private final int menuNumber;
    protected final CalculationLogRepository clrp;

    public SelectMenuExecutor(final int menuNumber, final CalculationLogRepository clrp) {
        this.menuNumber = menuNumber;
        this.clrp = clrp;
    }

    public boolean isNumberSatisfiedBy(final int selectMenuNumber) {
        return menuNumber == selectMenuNumber;
    }

    public abstract void execute() throws CalculatorException;
}
