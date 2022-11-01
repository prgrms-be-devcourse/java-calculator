package com.programmers.engine;

import com.programmers.engine.io.*;
import com.programmers.engine.model.*;
import com.programmers.engine.stack.*;
import com.programmers.engine.validate.BracketValidator;
import com.programmers.engine.validate.NumOperatorValidator;

import java.math.BigDecimal;
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

    private Operator operator;
    private Bracket bracket;

    Map<String, Operator> map = Map.of(
            Operator.MUL.toString(), Operator.MUL,
            Operator.DIV.toString(), Operator.DIV,
            Operator.PLUS.toString(), Operator.PLUS,
            Operator.MINUS.toString(), Operator.MINUS
    );


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

            if (a.equals(Bracket.CLOSE.toString())) { // 닫는 괄호면 무조건 숫자 2개 pop 해서 계산하기
                isBracketOpened.set(false);
                pop2AndCal(numDq, operatorDq, isDividedByZero);
            }
            else if (a.equals(Bracket.OPEN.toString())) {
                isBracketOpened.set(true);
            }
            else if (operator.find(a).isPresent()) {
                if (operatorDq.isEmpty()) {
                    operatorDq.addFirst(operator.find(a).get());
                }

                else if (operator.getPriority(operatorDq.pollFirst()) <= operator.getPriority(operator.find(a).get())) {
                    operatorDq.addFirst(operator.find(a).get());
                }
            }
            else
                numDq.addFirst(BigDecimal.valueOf(Double.parseDouble(a)));
        });

        while(!operatorDq.isEmpty()){
            pop2AndCal(numDq, operatorDq, isDividedByZero);
        }
        if (isDividedByZero.get())
            return BigDecimal.valueOf(Integer.MAX_VALUE); // 0으로 나누는 에러가 발생했다
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
                return Optional.of(b2.divide(b1, 2, BigDecimal.ROUND_HALF_DOWN));
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
