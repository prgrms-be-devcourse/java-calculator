import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

    private Integer optionNumber = 2;
    private ResultSaveService resultSaveService;
    private CalculateService calculateService;
    private static Map<Integer, CalculatorFunction> menus = new HashMap<>();
    private StringBuilder menusBuilder = new StringBuilder();
    private CalculatorFunction calculatorFunction;

    public Calculator(ResultSaveService resultSaveService, CalculateService calculateService) {
        this.resultSaveService = resultSaveService;
        this.calculateService = calculateService;
    }

    public static void main(String[] args) {

        ResultSaveService saveService = new ResultSaveService("조회");
        CalculateService calService = new CalculateService("계산");
        Calculator calculator = new Calculator(saveService, calService);

        calculator.menus.put(1, saveService);
        calculator.menus.put(2, calService);


        for (int i = 1; i <= calculator.menus.size(); i++) {
            calculator.menusBuilder.append(i + ". " + menus.get(i).getName() + "\n");
        }

        calculator.menusBuilder.append("\n");
        calculator.menusBuilder.append("선택 : ");

        calculator.run();
    }

    private void run() {

        while (true) {
            System.out.print(menusBuilder);
            Scanner scanner = new Scanner(System.in);

            try {
                 calculatorFunction = menus.get(scanner.nextInt());
                 calculatorFunction.doService(this);
            } catch (Exception e) {
                System.out.println("입력이 올바르지 않습니다.\n");
            }

        }
    }

    public ResultSaveService getResultSaveService() {
        return resultSaveService;
    }
}
