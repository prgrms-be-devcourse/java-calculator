package model.menu;

import repository.CalculationLogRepository;

public class LoadLogsMenuExecutor extends SelectMenuExecutor{
    public LoadLogsMenuExecutor(int menuNumber, CalculationLogRepository clrp) {
        super(menuNumber, clrp);
    }

    @Override
    public void execute() {
        clrp.loadAllLogs();
    }
}
