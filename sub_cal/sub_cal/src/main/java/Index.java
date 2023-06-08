
import model.Calculator;
import model.History;
import model.Operator;
import option.Option;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//사용자가 옵션을 선택할 수 있습니다.
//선택한 옵션에 맞게 switch 문으로 해당 옵션에 맞는 메소드를 호출합니다.
public class Index implements Runnable{
    private Console console;
    private History history;
    private Calculator calculator;
    private Operator operator;

    public Index(Console console, History history, Calculator calculator, Operator operator) {
        this.console = console;
        this.history = history;
        this.calculator = calculator;
        this.operator = operator;
    }

    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            for(Option opt : Option.values()){
                System.out.println(opt.getIdx()+". "+opt.getOpt());
            }


            int select = sc.nextInt();
            //스위치 문을 통하여 옵션에 맞는 코드를 실행합니다
            switch (select) {
                case 1:
                    console.getHistory(history);
                    break;
                case 2:
                    System.out.print("계산식을 입력해주세요 : ");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String inputString = br.readLine();
                        console.input(inputString,calculator,operator,history);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }

}
