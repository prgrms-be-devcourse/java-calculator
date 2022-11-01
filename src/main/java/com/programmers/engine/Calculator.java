package com.programmers.engine;

import com.programmers.engine.io.*;
import com.programmers.engine.model.*;
import com.programmers.engine.stack.*;
import com.programmers.engine.validate.BracketValidator;
import com.programmers.engine.validate.NumOperatorValidator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
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
        Stack<Operator> operatorStack = new Stack<>();
        Stack<BigDecimal> numStack = new Stack<>();

        AtomicBoolean isDividedByZero = new AtomicBoolean(false);
        AtomicBoolean isBracketOpened = new AtomicBoolean(false);


        formula.indexedForEach((a) -> {

            if(a.equals(Bracket.CLOSE.toString())){ // 닫는 괄호면 무조건 숫자 2개 pop 해서 계산하기
                isBracketOpened.set(false);
                BigDecimal tmp1 = numStack.pop();
                BigDecimal tmp2 = numStack.pop();

                Operator tmpOp = operatorStack.pop();

                Optional<BigDecimal> reuslt = arithmetic(tmp1, tmp2, tmpOp);
                if (reuslt.isPresent()) numStack.push(reuslt.get());
                else {
                    numStack.push(tmp1);
                    isDividedByZero.set(true);
                }
            }else if (a.equals(Bracket.OPEN.toString())){
                isBracketOpened.set(true);
            }
            else if(map.containsKey(a)){
                // 연산자가 나온 경우 > 이거는 연산자의 우선순위에 따라서 잘 결정해야함
                if (operatorStack.isEmpty()) operatorStack.push(map.get(a));
                // 연산자 스택이 비어있으면 무조건 그냥 넣기
                else if((operatorStack.peek().equals(Operator.PLUS) || operatorStack.peek().equals(Operator.MINUS))
                 && (a.equals(Operator.DIV.toString()) || a.equals(Operator.MUL.toString()))){
                    // 유일하게 연산자를 그냥 push 해도 되는 경우
                    // stack의 맨 위 연산자가 지금 검사하는 연산자보다 우선순위가 더 높은 경우
                    operatorStack.push(map.get(a));
                }else if (isBracketOpened.get()){
                    operatorStack.push(map.get(a));
                }
                else{
                    // 지금 들어온 연산자가 스택의 연산자보다 우선순위가 더 높거나 같으면 ? -> 2개 pop 하고 연산 진행
                    // 그리고 결과를 숫자 스택에 push 하고 지금의 연산자를 push 함
                    BigDecimal t1 = numStack.pop();
                    BigDecimal t2 = numStack.pop();
                    Operator tOp = operatorStack.pop();

                    Optional<BigDecimal> r = arithmetic(t1, t2, tOp);
                    if (r.isPresent()) numStack.push(r.get());
                    else {
                        numStack.push(t1); //  숫자 맞추기 위해 넣기
                        isDividedByZero.set(true); // 이거는 에러가 났다
                    }
                    operatorStack.push(map.get(a));
                }
            }
            else numStack.push(BigDecimal.valueOf(Double.parseDouble(a))); // 숫자는 그냥 숫자 stack 에 넣기
                });

        while (!operatorStack.isEmpty()){
            BigDecimal a1 = numStack.pop();
            BigDecimal a2 = numStack.pop();
            Operator o = operatorStack.pop();
            Optional<BigDecimal> ob = arithmetic(a1, a2, o);
            if (ob.isPresent()) numStack.push(ob.get());
            else{
                numStack.push(a2);
                isDividedByZero.set(true);
            }
        }
        if (isDividedByZero.get()) return BigDecimal.valueOf(Integer.MAX_VALUE); // 0으로 나누는 에러가 발생했다
        else return numStack.peek();
    }
    private void addToDB(DataBase db, Formula formula, BigDecimal ans){
        // DBfh 저장하는 메소드
        formula.addDataToDB(db, ans);
    }

    private Optional<BigDecimal> arithmetic(BigDecimal b1, BigDecimal b2, Operator op){
        // 단순 사칙연산을 위한 메소드
        if          (op.equals(Operator.MINUS))     return Optional.of(b2.subtract(b1));
        else if     (op.equals(Operator.PLUS))      return Optional.of(b2.add(b1));
        else if     (op.equals(Operator.MUL))       return Optional.of(b2.multiply(b1));
        else{ // op.equals(Operator.DIV)
            if (b1.equals(BigDecimal.ZERO)){
                output.inputError();
                return Optional.empty();
            }
            else return Optional.of(b2.divide(b1, 2, BigDecimal.ROUND_HALF_DOWN));
        }

    }
}
