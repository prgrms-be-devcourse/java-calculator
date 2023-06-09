import controller.CalculatorApplication;
import model.MenuService;
import model.menu.*;
import repository.CalculationLogRepository;
import repository.CalculationLogRepositoryImpl;

import static view.OutputView.*;
import static view.OutputView.printErrorMessage;

public class App {
    public static void main(String[] args) {
        CalculationLogRepository clrp =  new CalculationLogRepositoryImpl();
        SelectMenuExecutor loadDataMenu = new LoadLogsMenuExecutor(Menu.LOAD.getMenuNumber(), clrp);
        SelectMenuExecutor calculateMenu = new CalculationMenuExecutor(Menu.CALCULATE.getMenuNumber(), clrp);
        MenuService menuService = new MenuService(calculateMenu, loadDataMenu);
        CalculatorApplication app = new CalculatorApplication(menuService);

        try {
            app.run();
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
        }
    }
}
