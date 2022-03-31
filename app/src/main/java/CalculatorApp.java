import service.CalculatorUIService;

public class CalculatorApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CalculatorUIService calculatorUIService = appConfig.calculatorUIService();
        calculatorUIService.showInterface();
    }

}
