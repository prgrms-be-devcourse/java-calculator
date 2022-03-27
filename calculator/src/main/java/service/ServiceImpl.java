package service;

import io.Input;
import io.InputImpl;
import io.Output;
import io.OutputImpl;
import model.Option;
import repository.CalculatorRepository;

import java.util.Scanner;


public class ServiceImpl implements Runnable{

    private final CalculatorService calculatorService = new CalculatorServiceImpl();
    private final Input input = new InputImpl();
    private final Output output = new OutputImpl();


    @Override
    public void run() {
        while(true) {
            try {
                output.printOption();
                String ops = input.readLine();
                Option parse = Option.parse(ops);
                chooseOption(parse);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void chooseOption(Option parse) {
        switch (parse) {
            case INQUIRY : calculatorService.getResults();
            case CALCULATE: calculatorService.calculate();
            case EXIT: System.exit(0);
        };
    }
}
