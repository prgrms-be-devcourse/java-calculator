package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;

public class Calculator implements Runnable{

    private Input input;
    private Output output;
    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {

        while(true){

            //메뉴출력
            output.menu();
            int target = Integer.parseInt(input.input("선택 :"));

            //1번이 보여주기, 2번이 계산
            if(target == 1){
                //TODO: 지금까지 했던 기록 list 보여주기
                continue;
            }
            if(target == 2){
                //TODO: operator 만들기
                continue;
            }
            if(target == 3){
                output.quit();
                break;
            }
            output.inputError();
        }
    }
}
