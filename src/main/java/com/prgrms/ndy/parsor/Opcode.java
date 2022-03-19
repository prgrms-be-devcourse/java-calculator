package com.prgrms.ndy.parsor;

public enum Opcode {
    ADD('+'), SUB('-'), MUL('*'), DIV('/');

    private final char code;

    Opcode(char code) {
        this.code = code;
    }

}
