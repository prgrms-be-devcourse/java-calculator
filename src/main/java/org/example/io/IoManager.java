package org.example.io;

import org.example.calculation.Calculation;
import org.example.exception.BadEquationException;
import org.example.exception.CheckEquation;
import org.example.repository.Repository;

import java.io.IOException;

public class IoManager {
    private Calculation calculation;
    private Input input;
    private Output output;
    private Repository repository;

    public IoManager(Calculation calculation, Input input, Output output, Repository repository) {
        this.calculation = calculation;
        this.input = input;
        this.output = output;
        this.repository = repository;
    }

    public void run(){
        while (true){
            try {
                output.printAction("1.조회");
                output.printAction("2.계산");
                output.printAction("3.종료");
                System.out.println();

                String action = input.selectAction();
                String curInput;
                if(action.equals("2")) {
                    curInput = input.input();
                    validate(curInput);
                    int resultNnm = calculation.run(curInput);
                    output.printCaculatedResult(resultNnm);
                    System.out.println();
                    String resultStr = curInput + " = " + String.valueOf(resultNnm);
                    repository.save(resultStr);

                }else if (action.equals("1")){
                    String[] findStrArr = repository.findAll();
                    output.printFindAll(findStrArr);
                    System.out.println();

                }else if (action.equals("3")){
                    break;

                }else {
                    output.printAction("다시 입력해 주세요.");
                    System.out.println();
                }
            }catch (Exception e){
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.^^");
                System.out.println();
            }
        }
    }

    private void validate(String str){
        if (!CheckEquation.validateEquation(str)){
            throw new BadEquationException("잘못된 연산식이 입력 되었습니다.");
        }
    }
}
