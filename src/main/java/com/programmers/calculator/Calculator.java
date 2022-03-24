package com.programmers.calculator;

import com.programmers.calculator.service.CalcArithmeticService;
import com.programmers.calculator.service.CalcValidatorService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Calculator {
    CalcArithmeticService as = new CalcArithmeticService();
    CalcValidatorService vs = new CalcValidatorService();

    public double getResult(String formula) {
        double result;
        int target = 1;

        List<String> list = new ArrayList<>();
        String[] formulaArr = formula.split(" ");

        list.add(formulaArr[target - 1]);

        try {
            while (target < formulaArr.length - 1) {
                double pre = Double.parseDouble(formulaArr[target - 1]);
                double pos = Double.parseDouble(formulaArr[target + 1]);
                String symbol = formulaArr[target];

                switch (symbol) {
                    case "+", "-" -> {
                        list.add(symbol);
                        list.add(String.valueOf(pos));
                    }
                    case "*" -> {
                        double d = as.calcMulti(pre, pos);
                        formulaArr[target + 1] = String.valueOf(d);
                        list.remove(list.size() - 1);
                        list.add(String.valueOf(d));
                    }
                    case "/" -> {
                        double d = as.calcDivi(pre, pos);
                        formulaArr[target + 1] = String.valueOf(d);
                        list.remove(list.size() - 1);
                        list.add(String.valueOf(d));
                    }
                }
                target += 2;
            }

            String symbol = "";
            Iterator<String> iter = list.iterator();
            result = Double.parseDouble(iter.next());
            while (iter.hasNext()) {
                String s = iter.next();
                if (s.equals("+") || s.equals("-")) {
                    symbol = s;
                } else {
                    if (symbol.equals("+")) {
                        result += Double.parseDouble(s);
                    } else {
                        result -= Double.parseDouble(s);
                    }
                }
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            result = 0;
        }
        return result;
    }
}
