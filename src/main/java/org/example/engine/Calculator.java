package org.example.engine;

import org.apache.commons.lang3.StringUtils;
import org.example.Console;
import org.example.engine.enums.ArithmeticOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


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
        List<String> parseExpression =  parseExpression(preprocessedExpression);


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

    public List <String> parseExpression(String expression){
        return  Arrays.stream(expression.split(" ")).collect(Collectors.toList());
    }

    public List<String> infixToPostfix (List<String> infixExpression){
        List<String> postfixExpression = new ArrayList<>();
        Stack<String> st = new Stack<>();
        for(String ele : infixExpression){
            if(StringUtils.isNumeric(ele)){
                postfixExpression.add(ele);  continue;
            }

            if(st.isEmpty()){
                st.add(ele); continue;
            }

            ArithmeticOperator prevOperator = ArithmeticOperator.getArithmeticOperator(st.peek());
            ArithmeticOperator tempOperator = ArithmeticOperator.getArithmeticOperator(ele);
            if(ArithmeticOperator.comparePriority(prevOperator, tempOperator)<0){
                st.add(ele);
            }else{
                postfixExpression.add(st.pop());
                st.add(ele);
            }
        }

        while(!st.isEmpty())
            postfixExpression.add(st.pop());

        return postfixExpression;
    }












}