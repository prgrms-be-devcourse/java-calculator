package com.prgrms.ndy.parsor;

import com.prgrms.ndy.operation.Opcode;

import java.util.ArrayList;
import java.util.List;

public class CommandUnit implements Command {

    private int size;
    private List<? super Number> numbers = new ArrayList<>();
    private List<Opcode> ops = new ArrayList<>();


    public <T extends Number> void addNumber(T number) {
        numbers.add(number);
        size+=1;
    }

    public void addOpcode(Opcode opcode) {
        ops.add(opcode);
    }

    public int getSize() {
        return size;
    }

    @Override
    public Number proc() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < size-1; i++) {
            sb.append(numbers.get(i)).append(' ');
            sb.append(ops.get(i).getCode()).append(' ');
        }
        sb.append(numbers.get(i));
        return sb.toString();
    }
}
