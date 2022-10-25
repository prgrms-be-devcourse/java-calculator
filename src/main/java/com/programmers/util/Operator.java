package com.programmers.util;

public class Operator {
    public  static final int getPriority(Character c){
        int priority = -1;
        switch (c){
            case '+','-' -> priority = 4;
            case '*','/' -> priority = 3;
        }
        return priority;
    }
}
