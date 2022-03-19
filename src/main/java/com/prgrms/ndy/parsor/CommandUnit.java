package com.prgrms.ndy.parsor;

import java.util.ArrayList;
import java.util.List;

public class CommandUnit implements Command {

    private List<? super Number> numbers = new ArrayList<>();
    private List<Opcode> ops = new ArrayList<>();


    public <T extends Number> void addNumber(T number) {
        numbers.add(number);
    }

    public void addOpCode(Opcode opcode) {
        ops.add(opcode);
    }

    @Override
    public Number proc() {
        return 0;
    }
}
