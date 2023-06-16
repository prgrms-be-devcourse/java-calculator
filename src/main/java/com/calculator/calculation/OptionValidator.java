package com.calculator.calculation;

public class OptionValidator {
    private static String[] menuOptions = {"1","2","3"};
    public static boolean validate(String input){
        for(String option:menuOptions){
            if(input.equals(option))
                return true;
        }
        return false;
    }
}
