package com.prgrms.ndy.domain;

import java.util.*;

public class CommandUnit implements Command {

    private int size;
    private final List<Double> numbers = new ArrayList<>();
    private final List<Opcode> ops = new ArrayList<>();

    public static Command of(String expression) {
        CommandUnit commandUnit = new CommandUnit();
        String[] tokens = expression.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                commandUnit.addNumber(getNumber(tokens[i]));
            } else {
                Opcode opcode = Opcode.of(tokens[i].charAt(0))
                        .orElseThrow(() -> new IllegalStateException("DB에 이상한 OP 코드가 들어있습니다."));
                commandUnit.addOpcode(opcode);
            }
        }
        return commandUnit;
    }

    public void addNumber(Double number) {
        numbers.add(number);
        size += 1;
    }

    public void addOpcode(Opcode opcode) {
        ops.add(opcode);
    }

    @Override
    public Double proc() {
        Double init = numbers.get(0);
        Deque<Double> numberQueue = new LinkedList<>();
        Deque<Opcode> opQueue = new LinkedList<>();
        numberQueue.addLast(init);

        for (int i = 1; i < size; i++) {
            Opcode op = ops.get(i - 1);
            Double operandB = numbers.get(i);
            if (op == Opcode.MUL || op == Opcode.DIV) {
                Double operandA = numberQueue.pollLast();
                numberQueue.addLast(op.apply(operandA, operandB));
            } else {
                numberQueue.addLast(operandB);
                opQueue.addLast(op);
            }
        }

        Double result = numberQueue.pollFirst();
        while (!opQueue.isEmpty()) {
            result = opQueue.pollFirst().apply(result, numberQueue.pollFirst());
        }
        if(result.isInfinite()){
            throw new ArithmeticException("/ by zero");
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

    public static Double getNumber(String in) {
        return Double.valueOf(in);
    }
}
