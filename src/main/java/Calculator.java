import entity.Data;
import io.Input;
import io.Output;
import service.CalculatorService;
import validation.ValidateService;

public class Calculator implements Runnable{

    private final Input input;
    private final Output output;
    private final CalculatorService calculatorService;
    private final ValidateService validateService;

    public Calculator(Input input, Output output, CalculatorService calculatorService, ValidateService validateService) {
        this.input = input;
        this.output = output;
        this.calculatorService = calculatorService;
        this.validateService = validateService;
    }

    @Override
    public void run() {

        Long index = 0L;

        while (true) {
            String inputCommand = input.inputCommand("1. 조회\n2. 계산\n3. 종료");

            if (!validateService.isCorrectCommand(inputCommand)){
                output.inputError();
                continue;
            }

            Command command = getCommand(inputCommand);

            if (command == Command.SHOW) {
                calculatorService.showAllResult();
            }
            else if (command == Command.CALCULATE) {

                String calculationFormula = input.inputFormula("계산식을 입력하세요.");

                if (!validateService.isCorrectFormula(calculationFormula)) {
                    output.inputError();
                    continue;
                }

                String calculateResult = calculatorService.calculate(calculationFormula);

                Data data = new Data(index, calculationFormula, calculateResult);
                output.result(calculatorService.saveResult(data));

                index++;

            }
            else if (command == Command.EXIT) {
                System.out.println("종료합니다.");
                break;
            }
        }
    }

    private Command getCommand(String inputCommand) {
        switch (inputCommand){
            case "1":
                return Command.SHOW;
            case "2":
                return Command.CALCULATE;
            default:
                return Command.EXIT;
        }
    }
}
