package calculator.engine;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.model.OperatorOrder;
import calculator.repository.CalculationRepository;
import calculator.engine.calculate.Calculate;
import calculator.engine.parser.Parser;
import calculator.engine.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;

public class Calculator implements Runnable {

    private final Input input;
    private final Output output;

    private final Calculate calculate;
    private final Parser parser;
    private final Sorter sorter;
    private final CalculationRepository calculationRepository;

    public Calculator(Input input, Output output,
                      Calculate calculate,
                      Parser parser,
                      Sorter sorter,
                      CalculationRepository calculationRepository) {
        this.input = input;
        this.output = output;
        this.calculate = calculate;
        this.parser = parser;
        this.sorter = sorter;
        this.calculationRepository = calculationRepository;
    }

    private void initCalculateData(String[] splitArr, Double[] nums, List<OperatorOrder> orderedOperators) {
        for (int i = 0; i < splitArr.length; i++) {
            if (i % 2 == 0)
                nums[i] = Double.valueOf(splitArr[i]);
            else {
                orderedOperators.add(new OperatorOrder(splitArr[i].charAt(0), i));
            }
        }
    }

    private void exec(String command) {
        String parsedCmd = parser.parse(command);
        if (parsedCmd == null) {
            output.strangeCommand();
        } else {
            String[] splitArr = parsedCmd.split(" ");
            Double[] nums = new Double[splitArr.length];
            List<OperatorOrder> orderedOperators = new ArrayList<>();
            initCalculateData(splitArr, nums, orderedOperators);
            sorter.sort(orderedOperators);
            double result = calculate.calculate(nums, orderedOperators);
            String saveData = calculationRepository.save(command, result);
            output.calcResultPrint(saveData);
        }
    }

    @Override
    public void run() {
        try {
            boolean finish = false;
            while (!finish) {
                int n = Integer.valueOf(input.input("1. 조회\n2. 계산\n3. 종료"));
                switch (n) {
                    case 1:
                        output.selectAllCommand(calculationRepository.findAll());
                        break;
                    case 2:
                        exec(input.input(""));
                        break;
                    case 3:
                        finish = true;
                        break;
                    default:
                        output.wrongInput();
                        break;
                }
            }
        } catch (Exception e) {
            output.ExceptionMessage(e);
        }
    }
}
