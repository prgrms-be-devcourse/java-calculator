package com.programmers.project;



public class Basic {
    Verifier vf = new Verifier();

    public Double cal(Double num1, Double num2, String opt){
        switch (opt){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                vf.divideByZero(num2);
                return num1 / num2;
            default:
                vf.inValidOperation();
                return num1; // 의미없는 리턴값
        }
    }
}
