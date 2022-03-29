package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;
import main.calculator.engine.model.CalculationRepository;

public class Calculator implements Runnable{

    private Input input;
    private Output output;
    private CalculationRepository calculationRepository;

    public Calculator(Input input,
                      Output output,
                      CalculationRepository calculationRepository) {
        this.input = input;
        this.output = output;
        this.calculationRepository = calculationRepository;
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
                writeCalculation(input.input("입력해주세요"));
                continue;
            }
            if(target == 3){
                output.quit();
                break;
            }
            output.inputError();
        }
    }

    private void writeCalculation(String InputString) {
        //실질적 계산이 이루어져짐
        //repository에 저장
        String result=""; //여기에 실질적 계산으로 보내기
        calculationRepository.save(InputString,result);
        output.print(result);
    }
}
