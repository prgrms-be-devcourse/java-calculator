package com.programmers.engine.caculator;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

@Getter
public class PostfixCaculator implements Caculator{

    private String expression;
    private Stack<String> parsedExpression;
    private double result;
    public String getAllExpression() {
        return expression +"="+ this.getResult();
    }
    public String getResult(){
        String result = String.format("%.2f",this.result);
        return result;
    }


    @Override
    public void caculate(List<String> operatorAndNumbers) {
        Stack<Double> postfixStack = new Stack<>();
        for (String operatorAndNumber : operatorAndNumbers) {
        }
    }

    @Override
    public boolean isSucessfull() {
        return false;
    }

//    private String[] tokenize() throws Exception{
//        StringBuffer sb = new StringBuffer();
//        char[] tokens = this.expression.toCharArray();
//        String[] result = new String[]{};
//        for (char token : tokens) {
//            switch(token){
//                case '+' ->{
//
//                }
//                case '-' ->{
//
//                }
//                case '/' ->{
//
//                }
//                case  '*' ->{
//
//                }
//                default ->{
//                    if('0'<=token&& token<='9'){
//                        sb.append(token);
//                    }else{
//                        throw new Exception("잘못된 식 입니다.");
//                    }
//                }
//            }
//        }
//    }
}