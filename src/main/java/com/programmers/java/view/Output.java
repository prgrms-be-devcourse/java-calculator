package com.programmers.java.view;

import java.util.ArrayList;

public class Output {

    public void viewCalculateResult(double result) {
        System.out.println(result);
    }

    public void viewSearchResult(ArrayList<String> calcList) {
        for (String calc : calcList) {
            System.out.println(calc);
        }
    }
}