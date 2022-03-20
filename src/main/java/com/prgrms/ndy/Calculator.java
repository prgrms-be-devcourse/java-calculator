package com.prgrms.ndy;

import com.prgrms.ndy.io.ReaderWriter;
import com.prgrms.ndy.parsor.Command;
import com.prgrms.ndy.parsor.Parser;

public class Calculator {

    private final Parser parser;
    private final ReaderWriter rw;

    public Calculator(Parser parser, ReaderWriter rw) {
        this.parser = parser;
        this.rw = rw;
    }

    public void run() {
        try {
            do {
                rw.write("계산식을 입력해주세요. (F를 입력하면 종료됩니다.) : \n");
                String expr = rw.read();
                if (expr.equals("F")) {
                    break;
                }
                Command command;
                try {
                    command = parser.parse(expr);
                } catch (IllegalArgumentException e) {
                    rw.write("옳바른 계산식을 입력해주세요.\n");
                    continue;
                }
                rw.write("입력 계산식 :\n");
                rw.write(command + "\n");

                rw.write("결과 : " + command.proc() + "\n\n");
            } while (true);
        } finally {
            rw.close();
        }
    }
}
