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
                output.showArithmeticResults(repository.getAll());
            } else if (action == 2) {
                String formula = input.formula();
                formula = checkFormulaValidate(formula) ? formula : "";
                double arithmeticResult = 0;

                if (formula.equals("")) {
                    output.error("잘못된 입력입니다.");
                } else {
                    arithmeticResult = getArithmeticResult(formula);
                    repository.save(new CalcData(formula, arithmeticResult));
                }

                output.showArithmeticResult(arithmeticResult);
            } else if (action == -1) {
                break;
            } else {
                output.error("잘못된 입력입니다.");
            }
        }
    }

    public double getArithmeticResult(String formula) {
        double result;
        int target = 1;

        List<String> list = new ArrayList<>();
        String[] formulaArr = formula.split(" ");

        list.add(formulaArr[0]);

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

    private Boolean checkFormulaValidate(String formula) {
        return validatorService.checkNumsAndSymbol(formula)
                && validatorService.checkSymbolMatching(formula)
                && !formula.equals("");
    }
}
