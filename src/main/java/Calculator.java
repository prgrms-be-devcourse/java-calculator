import entity.Data;
import io.Input;
import io.Output;
import service.CalculatorService;
import validation.Validate;

public class Calculator implements Runnable{

    private final Input input;
    private final Output output;
    private final CalculatorService calculatorService;
    private final Validate validate;

    public Calculator(Input input, Output output, CalculatorService calculatorService, Validate validate) {
        this.input = input;
        this.output = output;
        this.calculatorService = calculatorService;
        this.validate = validate;
    }

    @Override
    public void run() {

        Long index = 0L;

        while (true) {
            String inputCommand = input.inputCommand("1. 조회\n2. 계산\n3. 종료");

            if (validate.isCorrectCommand(inputCommand)) {
                int command = Integer.parseInt(inputCommand);

                if (command == 1) {
                    calculatorService.showAllResult();

                } else if (command == 2) {
                    System.out.println("계산식을 입력하세요.");
                    String calculationFormula = input.inputFormula();

                    if (validate.isCorrectFormula(calculationFormula)) {
                        String calculateResult = calculatorService.calculate(calculationFormula);

                        Data data = new Data(index, calculationFormula, calculateResult);
                        output.result(calculatorService.saveResult(data));

                        index++;
                    } else {
                        output.inputError();
                        continue;
                    }

                } else if (command == 3) {
                    System.out.println("종료합니다.");
                    break;
                }
            } else {
                output.inputError();
                continue;
            }

        }
    }
}
