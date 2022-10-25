package com.programmers.calculation;

import java.util.List;

public class FourArithmeticImpl implements FourArithmetic{

    public String multi(List<String> calculationForm, int i) {
        return String.valueOf(Double.parseDouble(calculationForm.get(i-1)) * Double.parseDouble(calculationForm.get(i+1)));
    }

    public String division(List<String> calculationForm, int i) {
        return String.valueOf(Double.parseDouble(calculationForm.get(i-1)) / Double.parseDouble(calculationForm.get(i+1)));
    }

    public String add(List<String> calculationForm, int i) {
        return String.valueOf(Double.parseDouble(calculationForm.get(i-1)) + Double.parseDouble(calculationForm.get(i+1)));
    }

    public String subject(List<String> calculationForm, int i) {
        return String.valueOf(Double.parseDouble(calculationForm.get(i-1)) - Double.parseDouble(calculationForm.get(i+1)));
    }

}
