package com.prgrms.ndy;

import com.prgrms.ndy.domain.Calculation;
import com.prgrms.ndy.domain.Command;
import com.prgrms.ndy.io.ReaderWriter;
import com.prgrms.ndy.parsor.Parser;
import com.prgrms.ndy.repository.CalculationRepository;

import java.util.List;

public class Calculator {

    private final Parser parser;
    private final ReaderWriter rw;
    private final CalculationRepository repository;

    public Calculator(Parser parser, ReaderWriter rw, CalculationRepository repository) {
        this.parser = parser;
        this.rw = rw;
        this.repository = repository;
    }

    public void run() {
        repository.clear();
        try {
            do {
                rw.write("1. 조회\n2. 계산\n\n선택 : ");
                String expr = rw.read();
                if (expr.equals("F")) {
                    break;
                }
                int type;
                try {
                    type = getType(expr);
                } catch (IllegalArgumentException e) {
                    rw.write("1 or 2 중에 입력해주세요.\n");
                    continue;
                }

                if (type == 1) {
                    repository.findAll()
                            .forEach(c -> rw.write(c.display()+"\n"));
                } else if (type == 2) {
                    procCalculation();
                }
            } while (true);
        } finally {
            rw.close();
        }
    }

    private boolean procCalculation() {
        Command command;
        try {
            command = parser.parse(rw.read());
        } catch (IllegalArgumentException e) {
            rw.write("옳바른 계산식을 입력해주세요.\n");
            return false;
        }
        Number result = command.proc();
        rw.write(result + "\n\n");

        repository.save(new Calculation(command, result));
        return true;
    }

    private int getType(String requestType) {
        int type = Integer.parseInt(requestType);
        if (type < 1 || type > 2) throw new IllegalArgumentException();
        return type;
    }
}
