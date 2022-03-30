package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;
import main.calculator.engine.model.CalculationRepository;

import java.util.Optional;

public class Calculator implements Runnable{

    private Integer LOOKUP = 1;
    private Integer CALCULATION = 2;
    private Integer EXIT = 3;

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
            String inputString = input.input("선택 :");
            Optional<Integer> target = parse(inputString);

            //1,2,3을 제외한 다른문자가 들어오면 다시 돌리기
            if(target.isEmpty()){
                output.inputError();
                continue;
            }

            //1번이 보여주기, 2번이 계산, 3번이 끝
            if(LOOKUP.equals(target.get())){
                //TODO: 지금까지 했던 기록 list 보여주기
                continue;
            }
            if(CALCULATION.equals(target.get())){
                //TODO: operator 만들기
                writeCalculation(input.input("입력해주세요."));
                continue;
            }
            if(EXIT.equals(target.get())){
                output.quit();
                break;
            }

        }
    }

    private void writeCalculation(String InputString) {
        //실질적 계산이 이루어져짐
        //repository에 저장
        String result=""; //여기에 실질적 계산으로 보내기
        calculationRepository.save(InputString,result);
        output.print(result);
    }

    private Optional<Integer> parse(String selectString) {
        //1~3만 들어와야 함
        try {
            int number = Integer.parseInt(selectString);
            if (number < 1 || number > 3) {
                //숫자형태가 아님
                throw new NumberFormatException();
            }

            return Optional.of(number);
        }
        catch(NumberFormatException e){
            //1~3아니면 empty
            return Optional.empty();
        }
    }
}
