package calculator.console;

import calculator.console.util.MenuType;
import calculator.serice.CalculateService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleViewer implements Viewer {

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

            if(type.equals(MenuType.CALCULATE)){
                String equation = getEquation();
                int result = calculateService.calculate(equation);
                printResult(result);

            } else if(type.equals(MenuType.HISTORY)){
                List<String> history = calculateService.history();
                printHistory(history);
            } else{
                break;
            }
        }

    }

    private void printMenu(){
        System.out.println("1. 조회");
        System.out.println("2. 계산");
    }

    private void printResult(int result){
        System.out.println(result);
    }

    private void printHistory(List<String> history){
        history.forEach(System.out::println);
    }

    private MenuType getType(){
        String command = "";
        try{
            command = reader.readLine();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        if(MenuType.isCalculate(command)) return MenuType.CALCULATE;
        else if(MenuType.isHistory(command)) return MenuType.HISTORY;
        else return MenuType.EXIT;
    }

    private String getEquation(){
        String command = "";
        try{
            command = reader.readLine();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        return command;
    }
}
