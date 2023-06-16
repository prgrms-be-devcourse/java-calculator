package org.example.controller;

import org.example.compute.Compute;
import org.example.exception.BadEquationException;
import org.example.util.CheckEquation;
import org.example.io.Input;
import org.example.io.Output;
import org.example.repository.EquationRepository;
import org.example.util.Menu;

import java.io.IOException;
import java.util.List;

import static org.example.util.Menu.CALCULATE;
import static org.example.util.Menu.EXIT;
import static org.example.util.Menu.QUERY;

public class CalculatorController implements Runnable{
    private final Compute compute;
    private final Input input;
    private final Output output;
    private final EquationRepository equationRepository;

    public CalculatorController(Compute compute, Input input, Output output, EquationRepository equationRepository) {
        this.compute = compute;
        this.input = input;
        this.output = output;
        this.equationRepository = equationRepository;
    }

    @Override
    public void run(){
        while (true){
            try {
                output.printAction();
                Menu curMenu = Menu.getMenu(input.selectAction());

                if(curMenu == QUERY) queryAction();
                else if (curMenu == CALCULATE) calculateAction();
                else if (curMenu == EXIT) break;
                else output.printIoError();

            }catch (IOException IOe){
                output.printIoError();
            }catch (BadEquationException BEe){
                output.printEquationError();
            }
        }
    }

    private void calculateAction() throws IOException {
        String curInput = input.getUserEquation();
        CheckEquation.validate(curInput);
        double resultNum = compute.operate(curInput);
        output.printCalculatedResult(resultNum);
        equationRepository.save(curInput, resultNum);
    }

    private void queryAction() {
        List<String> history = equationRepository.findAll();
        output.printFindAll(history);
    }

}
