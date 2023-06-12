package calculator.engine.model;

import calculator.engine.enums.ConsoleMenu;
import calculator.engine.enums.Operators;

import java.util.ArrayList;

public class Parser {
    private ArrayList<String> inputParser = new ArrayList<>();
    public ConsoleMenu consoleParser(String selectMenu){
        if(selectMenu.equals("1")){
            return ConsoleMenu.ONE;
        }else if(selectMenu.equals("2")){
            return ConsoleMenu.TWO;
        }else
            return null;
    }
    public Operators operatorParser(String operParser) {
        switch (operParser) {
            case "+" :
                return Operators.PLUS;
            case "-" :
                return Operators.MINUS;
            case "*" :
                return Operators.MULTIPLICATION;
            case "/" :
                return Operators.DIVISION;
        }
        return null;
    }
    public ArrayList<String> getInputParser(){
        return inputParser;
    }
    public void setInputParser(ArrayList<String> inputParser){
        this.inputParser = inputParser;
    }
}
