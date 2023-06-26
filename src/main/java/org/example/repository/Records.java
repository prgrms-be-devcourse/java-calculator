package org.example.repository;

import java.util.ArrayList;
import java.util.List;

public class Records {

    private List<String> arithmeticRecords = new ArrayList<>();

    public void saveRecord(String infixExpression, double result){
        arithmeticRecords.add(infixExpression.toString() + " = " + result);
    }

    public List<String> exportRecord(){
        return arithmeticRecords;
    }

}
