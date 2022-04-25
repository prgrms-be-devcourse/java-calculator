package com.programmers.project;

import com.programmers.project.io.Console;

import static java.lang.Character.isDigit;
import static java.lang.System.exit;

public class Verifier {
    Console console = new Console();

    void divideByZero(double num2){
        if(num2 == 0){
            console.divideByZeroMsg();
            exit(0);
        }
    }

    void inValidOperation(){
        console.inValidMsg();
        exit(0);
    }

//    boolean isNumber(String number){
//
//        for(int i=0; i<number.length(); i++){
//            if(!isDigit(number.charAt(i))){
//                return false;
//            }
//        }
//        return true;
//    }

    boolean isOperation(String op){
        if(op.equals("+"))return true;
        else if(op.equals("-")) return true;
        else if(op.equals("/")) return true;
        else if(op.equals("*")) return true;
        else return false;
    }


}
