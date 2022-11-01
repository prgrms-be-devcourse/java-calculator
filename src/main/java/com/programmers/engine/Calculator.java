package com.programmers.engine;

import com.programmers.engine.io.*;
import com.programmers.engine.model.*;
import com.programmers.engine.stack.*;
import com.programmers.engine.validate.BracketValidator;
import com.programmers.engine.validate.NumOperatorValidator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;


public class Calculator implements Runnable{

    private final Input input;
    private final Output output;
    private final DataBase dataBase;
    private final Formula formula;
    private final BracketValidator bracketValidator;

    private final NumOperatorValidator numOperatorValidator;

    public Calculator(Input input, Output output, DataBase dataBase, Formula formula,
                      BracketValidator bracketValidator, NumOperatorValidator numOperatorValidator){
        this.input = input;
        this.output = output;
        this.dataBase = dataBase;
        this.formula = formula;
        this.bracketValidator = bracketValidator;
        this.numOperatorValidator = numOperatorValidator;
    }


    @Override
    public void run() {
        while(true) {
            String inputString = input.input("1. 조회\n2. 계산\n3. 종료\n선택 : ");
            if (inputString.length() != 1) {
                output.wrongChoice();
                continue;
            }

            Optional<Integer> num = parse(inputString);
            BigDecimal ans = BigDecimal.valueOf(0);

            if (num.get() == 1) {
                dataBase.showAll(output);
                continue;
            } else if (num.get() != 2)
                break;
            else if (num.isEmpty()) {
                output.inputError();
                continue;
            }

            output.caution();
            formula.makeFormula(input.input("계산식 입력 : "));

            if (!formula.validate(bracketValidator)) {
                output.bracketValidationError();
                continue;
            }

            if (!formula.validate(numOperatorValidator)) {
                output.numOperatorValidationError();
                continue;
            }

            ans = calculate(formula);
            System.out.println(ans);

            if (!ans.equals(BigDecimal.valueOf(Integer.MAX_VALUE))) {
                addToDB(dataBase, formula, ans);
                formula.clearContent();
            } else
                output.divdeByZeroError();
        }
        output.bye();
    }

    private Optional<Integer> parse(String inputString){
        if (inputString.length() == 0) return Optional.empty();

        int tmp;

        try {
            tmp = Integer.parseInt(inputString);
        }
        catch (Exception e){
            return Optional.empty();
        }

        return Optional.of(tmp);
    }
    private BigDecimal calculate(Formula formula){
        Deque<BigDecimal> numDq = new ArrayDeque<>();
        Deque<Operator> operatorDq = new ArrayDeque<>();

        AtomicBoolean isDividedByZero = new AtomicBoolean(false);
        AtomicBoolean isBracketOpened = new AtomicBoolean(false);

        formula.indexedForEach((a) -> {

            if(Bracket.find(a).equals(Optional.of(Bracket.CLOSE))){
                isBracketOpened.set(false);
                pop2AndCal(numDq, operatorDq, isDividedByZero);
            }
            else if (Bracket.find(a).equals(Optional.of(Bracket.OPEN))) {
                isBracketOpened.set(true);
            }
            else if (Operator.find(a).isPresent()) {
                if (operatorDq.isEmpty()) {
                    operatorDq.addFirst(Operator.find(a).get());
                }

                else if (Operator.getPriority(operatorDq.pollFirst()) <= Operator.getPriority(Operator.find(a).get())) {
                    operatorDq.addFirst(Operator.find(a).get());
                }
            }
            else
                numDq.addFirst(BigDecimal.valueOf(Double.parseDouble(a)));
        });

        while(!operatorDq.isEmpty()){
            pop2AndCal(numDq, operatorDq, isDividedByZero);
        }
        if (isDividedByZero.get())
            return BigDecimal.valueOf(Integer.MAX_VALUE);
        else
            return numDq.pollFirst();
    }
    private void addToDB(DataBase db, Formula formula, BigDecimal ans){
        formula.addDataToDB(db, ans);
    }

    private Optional<BigDecimal> arithmetic(BigDecimal b1, BigDecimal b2, Operator op){
        if      (op.equals(Operator.MINUS))
            return Optional.of(b2.subtract(b1));
        else if (op.equals(Operator.PLUS))
            return Optional.of(b2.add(b1));
        else if (op.equals(Operator.MUL))
            return Optional.of(b2.multiply(b1));
        else{
            if (b1.equals(BigDecimal.ZERO)){
                output.inputError();
                return Optional.empty();
            }
            else
                return Optional.of(b2.divide(b1, 2, RoundingMode.HALF_UP));
        }
    }

    private void pop2AndCal(Deque<BigDecimal> numDq, Deque<Operator> OperatorDeque, AtomicBoolean isZero){
        BigDecimal tmp1 = numDq.pop();
        BigDecimal tmp2 = numDq.pop();
        Operator o = OperatorDeque.pop();

        Optional<BigDecimal> result = arithmetic(tmp1, tmp2, o);

        if (result.isPresent())
            numDq.addFirst(result.get());
        else{
            numDq.addFirst(tmp2);
            isZero.set(true);
        }
    }
}
