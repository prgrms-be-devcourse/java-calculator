package main.calculator;

import main.calculator.engine.io.Input;
import main.calculator.engine.io.Output;
import main.calculator.engine.model.CalculationRepository;

import java.util.List;
import java.util.Optional;

public class Calculator implements Runnable{

    private final int SHOW_ALL = 1;
    private final int CALCULATION = 2;
    private final int EXIT = 3;

    private Input input;
    private Output output;
    private CalculationRepository calculationRepository;
    private Operator operator;
    private boolean exit = false;
    public Calculator(Input input,
                      Output output,
                      CalculationRepository calculationRepository,
                      Operator operator) {
        this.input = input;
        this.output = output;
        this.calculationRepository = calculationRepository;
        this.operator = operator;
    }

    @Override
    public void run() {

        while(true){
            //메뉴출력
            output.menu();
            String inputString = input.input("선택 :");

            //1번이 보여주기, 2번이 계산, 3번이 끝
            try{
                int target = parse(inputString);
                switch (target){
                    case SHOW_ALL:
                        showList(calculationRepository.findAll());
                        break;
                    case CALCULATION:
                        expressCalculation(input.input("입력해주세요."));
                        break;
                    case EXIT:
                        output.quit();
                        exit =true;
                        break;
                }
            }catch (SelectException e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요");
            }
            
            //3번이 들어왔다면 종료
            if(exit){
                break;
            }
        }
    }

    private void expressCalculation(String inputString) {
        //실질적 계산이 이루어짐
        
        //여기에 실질적 계산으로 보내기
        String result = operator.calculate(inputString);

        //repository에 저장
        calculationRepository.save(inputString,result);
        
        //출력
        output.print(result);
    }

    private void showList(List<String> list){
        //repository에서 가져온 list를 전체적으로 출력하기
        if(list.isEmpty()){
            output.print("조회할 내용이 없습니다.");
            return ;
        }

        for (String content : list) {
            output.print(content);
        }
    }


    private int parse(String selectString) {
        //1~3만 들어와야 함
        int number = Integer.parseInt(selectString);
        if (number >= 1 && number <= 3) {
            return number;
        }
        throw new SelectException("숫자중 1~3를 선택해주세요.");
    }
}
