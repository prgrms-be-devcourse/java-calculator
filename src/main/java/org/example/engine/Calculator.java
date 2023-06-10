package org.example.engine;

import org.example.Console;

import java.util.Stack;
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
        String inputExpression = console.inputExpression();
        String preprocessedExpression = preprocess(inputExpression);
        if(!validateExpression(preprocessedExpression)) System.out.println("예외를 발생시키겠어요");


    }

    public void loadHistory(){
        System.out.println("laodHistory에요");
    }


    public String preprocess(String rowExpression){
        String preprocessedExpression = rowExpression.trim();
        preprocessedExpression = preprocessedExpression.replaceAll("\\s+", " ");
        preprocessedExpression = preprocessedExpression.replaceAll("(?<=\\d)\\s+(?=\\d)", "");
        return preprocessedExpression;

    }

    public boolean validateExpression(String expression){
        String regex = "^\\d+(\\s*[+\\-*/]\\s*\\d+)*$";
        return Pattern.matches(regex, expression);

    }




    public String infixToPostfix(String infixExpression){
        StringBuilder postfixExpression =new StringBuilder();
        Stack<String> st = new Stack<>();


        return postfixExpression.toString();
    }












}
