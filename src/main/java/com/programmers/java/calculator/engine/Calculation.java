package com.programmers.java.calculator.engine;

import java.util.ArrayList;
import java.util.Stack;

// 계산
public class Calculation {
    // 중위 표기식 -> 후위 표기식 변환
    public ArrayList infixTopostfic(String s){
        ArrayList<Object> postFix = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                postFix.add(c);
            }
            else{
                switch (c){
                    case '+':

                }
            }
        }
    }

    // 후위 표기식으로 계산 결과 return
}
