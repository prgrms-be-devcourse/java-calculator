package com.programmers.calculator;

import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;
import com.programmers.calculator.model.CalcData;
import com.programmers.calculator.repository.Repository;
import com.programmers.calculator.service.ArithmeticService;
import com.programmers.calculator.service.ValidatorService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class Calculator {
    private Input input;
    private Output output;
    private Repository repository;
    private ArithmeticService arithmeticService;
    private ValidatorService validatorService;

    public void run() {
        while (true) {
            output.select();

            int action = input.action();

            if (action == 1) {
                output.results(repository.getAll());
            }

            if (action == 2) {
                String formula = typeFormula(input.formula());
                double result = 0;

                if (formula.equals("")) {
                    output.error("잘못된 입력입니다.");
                } else {
                    result = getResult(formula);
                    repository.save(new CalcData(formula, result));
                }

                output.result(result);
            }

            if (action == -1) {
                break;
            }
        }
    }

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
                        double d = arithmeticService.calcMulti(pre, pos);
                        formulaArr[target + 1] = String.valueOf(d);
                        list.remove(list.size() - 1);
                        list.add(String.valueOf(d));
                    }
                    case "/" -> {
                        double d = arithmeticService.calcDivi(pre, pos);
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
            output.error(e.getMessage());
            result = 0;
        }
        return result;
    }

    private String typeFormula(String formula) {
        if (!validatorService.checkNumsAndSymbol(formula)
                || !validatorService.checkSymbolMatching(formula)
                || formula.equals("")) {
            return "";
        }

        return formula;
    }
}
