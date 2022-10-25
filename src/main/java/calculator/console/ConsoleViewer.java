package calculator.console;

import calculator.dto.Calculation;
import calculator.enums.MenuType;
import calculator.service.CalculateService;
import calculator.util.Validations;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

//콘솔 기반으로 사용자 UI를 제공하는 클래스. Viewer 인터페이스를 구현
public class ConsoleViewer implements Viewer {

    //외부(Main.java)에서 생성자 주입을 받아 사용
    private final CalculateService calculateService;
    private final BufferedReader reader;

    public ConsoleViewer(CalculateService calculateService){
        this.calculateService = calculateService;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(){

        MenuType type;
        while(true){
            printMenu();
            type = getType();
            System.out.println();

            if(type.equals(MenuType.CALCULATE)) calculate();
            else if(type.equals(MenuType.HISTORY)) showHistory();
            else break;
            System.out.println();
        }

    }

    private void showHistory() {
        List<Calculation> history = calculateService.history();
        history.forEach(System.out::println);
    }

    private void calculate() {
        String equation = "";
        try{
            equation = reader.readLine();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        if(Validations.correctEquation(equation)) {

            int result = calculateService.calculate(equation);
            calculateService.save(new Calculation(equation, result));
            printResult(result);
        } else{
            System.out.println("잘못된 계산식입니다.");
        }
    }

    private MenuType getType(){
        String command = "";
        try{
            command = reader.readLine();
        } catch(IOException e){
            System.out.println(e.getMessage()); //exception을 처리하는 더 좋은 방법이 있을까요?
        }

        if(MenuType.isCalculate(command)) return MenuType.CALCULATE;
        else if(MenuType.isHistory(command)) return MenuType.HISTORY;
        else return MenuType.EXIT;
    }

    private void printMenu(){
        System.out.println("1. 조회");
        System.out.println("2. 계산");
    }

    private void printResult(Number result){
        System.out.println(result);
    }
}
