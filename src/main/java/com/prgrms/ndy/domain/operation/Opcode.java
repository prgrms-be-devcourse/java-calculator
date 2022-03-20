package com.prgrms.ndy.domain.operation;

import java.util.Optional;

public enum Opcode {
    ADD('+'), SUB('-'), MUL('*'), DIV('/');

    private final char code;

    Opcode(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Optional<Opcode> of(char code){
        for (Opcode opcode : Opcode.values()) {
            if(opcode.code == code){
                return Optional.of(opcode);
            }
        }
        return Optional.empty();
    }
}
