package com.programmers.java.engine.model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

public class Calculator {

    private ArrayList<String> posixList=new ArrayList<String>();
    private Stack<Operator> stack=new Stack<Operator>();


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
        return null;
    }

    //속에서 호출된 함수에서 에러발생시 바깥함수까지 모두 throws를 붙이는게 맞는건지?
    //모든 함수에 대해 유효하지 않은 매개변수가 들어왔을 때의 경우를 다 생각해야하는지!

    public void changeToPosix(String[] userStr) throws NumberFormatException{
        for(String str : userStr){
            // null이면 A, 아니면 B 로직 함수화 가능할듯.
            Optional<Operator> operator=Operator.getOperator(str);
            if(operator.isPresent()) {
                //연산자
                if (stack.isEmpty()) stack.push(operator.get());
                else {
                    int diff=stack.peek().getPriority()-operator.get().getPriority();
                    if(diff>=0) posixList.add(stack.pop().toString());
                    else stack.push(operator.get());
                }
                continue;
            }
            posixList.add(str);
        }
        while(!stack.isEmpty()){
            posixList.add(stack.pop().toString());
        }
    }

    private double unitCalculate(String operator, double a, double b){
        return Operator.calculate(operator, a, b);
    }


}
