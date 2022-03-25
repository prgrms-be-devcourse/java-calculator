package com.prgrms.ndy.domain;

import java.util.*;

public class CommandUnit implements Command {

    private int size;
    private final List<Double> numbers = new ArrayList<>();
    private final List<Op> ops = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public static Command of(String expression) {
        CommandUnit commandUnit = new CommandUnit();
        String[] tokens = expression.split(" ");
        initializeCommandUnitByTokens(commandUnit, tokens);
        return commandUnit;
    }

    private static void initializeCommandUnitByTokens(CommandUnit commandUnit, String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                commandUnit.addNumber(getNumber(tokens[i]));
            } else {
                commandUnit.addOp(getOp(tokens[i]));
            }
        }
    }

    private static Op getOp(String token) {
        return Op.of(token.charAt(0))
                .orElseThrow(() -> new IllegalStateException("이상한 OP 코드가 들어있습니다."));
    }

    public static Double getNumber(String in) {
        return Double.valueOf(in);
    }

    public void addNumber(double number) {
        numbers.add(number);
        size += 1;
    }

    public void addOp(Op op) {
        ops.add(op);
    }

    @Override
    public Double proc() {
        Double init = numbers.get(0);
        Deque<Double> numberQueue = new LinkedList<>();
        Deque<Op> opQueue = new LinkedList<>();
        numberQueue.addLast(init);

        procMulAndDiv(numberQueue, opQueue);
        return procAddAndSub(numberQueue, opQueue);
    }

    private void procMulAndDiv(Deque<Double> numberQueue, Deque<Op> opQueue) {
        for (int i = 1; i < size; i++) {
            Op op = ops.get(i - 1);
            Double operandB = numbers.get(i);
            if (op == Op.MUL || op == Op.DIV) {
                Double operandA = numberQueue.pollLast();
                numberQueue.addLast(op.apply(operandA, operandB));
            } else {
                numberQueue.addLast(operandB);
                opQueue.addLast(op);
            }
        }

        if (numberQueue.contains(Double.POSITIVE_INFINITY) || numberQueue.contains(Double.NEGATIVE_INFINITY)) {
            throw new ArithmeticException("/ by zero");
        }
    }

    private Double procAddAndSub(Deque<Double> numberQueue, Deque<Op> opQueue) {
        Double result = numberQueue.pollFirst();
        while (!opQueue.isEmpty()) {
            result = opQueue.pollFirst().apply(result, numberQueue.pollFirst());
        }
        return result;
    }

    @Override
    public String toString() {
        if (size == 0) return "{Empty Command}";

        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < size - 1; i++) {
            sb.append(numbers.get(i)).append(' ');
            sb.append(ops.get(i).getCode()).append(' ');
        }
        sb.append(numbers.get(i));
        return sb.toString();
    }
}
