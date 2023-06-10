package org.example.engine;

import org.example.Console;
import java.util.regex.Pattern;


public class Calculator implements Runnable{
    private Console console;

    public Calculator(Console console){
        this.console = console;
    }

    @Override
    public void run() {

        while(true){
            int mode = console.inputSelectMode();

            switch(mode){
                case 1 : compute(); break;
                case 2 : loadHistory(); break;
            }
        }

    }

    public void compute(){
        String expression = console.inputExpression();
        String trimExpression = expression.trim();
        if(!validateExpression(trimExpression)) System.out.println("예외를 발생시키겠어요");


    }

    public void loadHistory(){
        System.out.println("laodHistory에요");
    }

    public boolean validateExpression(String expression){
        String regex = "^\\d+(\\s*[+\\-*/]\\s*\\d+)*$";
        return Pattern.matches(regex, expression);



    }









}
