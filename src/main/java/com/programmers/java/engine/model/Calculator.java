package com.programmers.java.engine.model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

public class Calculator {

    private ArrayList<String> posixList=new ArrayList<String>();

    public String getPosixList(){
        String str="";
        for(int i=0; i<posixList.size(); i++){
            str+=posixList.get(i);
        }
        return str;
    }

    public String calculate(String[] userStr){
        changeToPosix(userStr);
        //posixList 계산
        Stack<Double> stack=new Stack<Double>();
        double ans=0;
        for(String str : posixList){
            Optional<Operator> operator=Operator.getOperator(str);
            if(operator.isEmpty()) {
                //피연산자
                stack.push(Double.parseDouble(str));
                continue;
            }
            //연산자
            if(stack.size()>=2){
                double num1=stack.pop();
                double num2=stack.pop();
                ans=Operator.calculate(str, num2, num1);
            }
            stack.push(ans);
        }

        if(ans==(int)ans) return Integer.toString((int)ans);
        return String.format("%.2f", stack.pop());
    }

    //TODO : 속에서 호출된 함수에서 에러발생시 바깥함수까지 모두 throws를 붙이는게 맞는건지?
    //TODO : 모든 함수에 대해 유효하지 않은 매개변수가 들어왔을 때의 경우를 다 생각해야하는지!

    private void changeToPosix(String[] userStr) throws NumberFormatException{
        Stack<Operator> stack=new Stack<Operator>();
        for(String str : userStr){
            // null이면 A, 아니면 B 로직 함수화 가능할듯.
            Optional<Operator> operator=Operator.getOperator(str);
            if(operator.isPresent()) {
                //연산자
                if (stack.isEmpty()) stack.push(operator.get());
                else {
                    int diff=stack.peek().getPriority()-operator.get().getPriority();
                    if(diff>=0) posixList.add(stack.pop().toString());
                    stack.push(operator.get());
                }
                continue;
            }
            posixList.add(str);
        }
        while(!stack.isEmpty()){
            posixList.add(stack.pop().toString());
        }
    }


}
