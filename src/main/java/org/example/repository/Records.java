package org.example.repository;

import java.util.ArrayList;
import java.util.List;

public class Records {

    private static List<String> arithmeticRecords = new ArrayList<>();

    public static void saveRecord(String infixExpression, double result){
        arithmeticRecords.add(infixExpression.toString() + " = " + result);
    }

    public static List<String> exportRecord(){
        return arithmeticRecords;
    }

}
