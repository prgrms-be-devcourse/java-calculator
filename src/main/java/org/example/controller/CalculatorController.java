package org.example.controller;

import org.example.calculation.Compute;
import org.example.exception.BadEquationException;
import org.example.util.CheckEquation;
import org.example.io.Input;
import org.example.io.Output;
import org.example.repository.EquationRepository;

import java.io.IOException;

public class CalculatorController implements Runnable{
    private Compute compute;
    private Input input;
    private Output output;
    private EquationRepository equationRepository;

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
                String action = input.selectAction();
                String curInput;

                if(action.equals("1")) {
                    String[] findStrArr = equationRepository.findAll();
                    output.printFindAll(findStrArr);
                    System.out.println();

                }else if (action.equals("2")){
                    curInput = input.getUserEquation();
                    validate(curInput);
                    double resultNnm = compute.operate(curInput);
                    output.printCaculatedResult(resultNnm);
                    System.out.println();
                    String resultStr = curInput + " = " + String.valueOf(resultNnm);
                    equationRepository.save(resultStr);

                }else if (action.equals("3")){
                    break;

                }else {
                    System.out.println("다시 입력해 주세요.");
                    System.out.println();
                }
            }catch (IOException IOe){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.^^");
                System.out.println();
            }catch (BadEquationException BEe){
                System.out.println("잘못된 수식이 입력 되었습니다.");
                System.out.println();
            }
        }
    }

    private void validate(String str){
        if (!CheckEquation.validateEquation(str)){
            throw new BadEquationException("잘못된 수식이 입력 되었습니다.");
        }
    }
}
