package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;

public class Calculator implements Runnable{

    private Input input;
    private Output output;
    boolean quit = false;
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
            switch (target){
                case 1: break;
                case 2: break;
                case 3: quit = true; break;
                default: output.inputError(); break;
            }

            if(quit){
                output.quit();
                break;
            }
        }


    }
}
