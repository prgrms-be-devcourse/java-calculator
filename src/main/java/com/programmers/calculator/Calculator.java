package com.programmers.calculator;

import com.programmers.calculator.entity.CalcData;
import com.programmers.calculator.repository.MemoryRepository;
import com.programmers.calculator.service.CalcArithmeticService;
import com.programmers.calculator.service.CalcKeyBoardService;
import com.programmers.calculator.service.CalcValidatorService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Calculator {
    CalcArithmeticService as = new CalcArithmeticService();
    CalcValidatorService vs = new CalcValidatorService();
    CalcKeyBoardService ks = new CalcKeyBoardService();
    MemoryRepository mr = new MemoryRepository();

    public void init() {
        while (true) {
            int action = typeAction();

            if (action == 1) {
                mr.printAll();
            }

            if (action == 2) {
                String formula = typeFormula();

                System.out.println();

                if (formula.equals("")) {
                    System.out.println("잘못된 입력입니다.");
                } else {
                    Double result = getResult(formula);

                    mr.save(new CalcData(formula, result));

                    System.out.println(result);
                }

                System.out.println();
            }

            if (action == -1) {
                break;
            }
        }
    }

    private int typeAction() {
        return ks.selectAction();
    }

    private String typeFormula() {
        String formula = ks.inputFormula();
        if (vs.checkNumsAndSymbol(formula)
                || vs.checkSymbolMatching(formula)
                || formula.equals("")) {
            return "";
        }
        formula = vs.checkSpacing(formula);

        return vs.checkSpacingVerified(formula) ? formula : "";
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
