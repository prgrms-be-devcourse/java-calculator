package calculator.engine;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.model.CalculationDto;
import calculator.service.CalculateService;

import java.util.List;

public class Calculator implements Runnable {

    private final CalculateService calculationService;
    private final Input input;
    private final Output output;

    public Calculator(CalculateService calculationService, Input input, Output output) {
        this.calculationService = calculationService;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String n = input.input("1. 조회\n2. 계산\n3. 종료");
                int intN = Integer.valueOf(n);
                if (intN == 1) {
                    List<String> all = calculationService.findAll();
                    output.selectAllCommand(all);
                } else if (intN == 2) {
                    String command = input.input("");
                    CalculationDto calculate = calculationService.calculate(command);
                    if (calculate == null)
                        output.strangeCommand();
                    else
                        output.calcResultPrint(calculate);
                } else if (intN == 3) {
                    break;
                } else {
                    output.wrongInput();
                    continue;
                }
            }
        } catch (Exception e) {
            output.ExceptionMessage(e);
        }
    }
}
