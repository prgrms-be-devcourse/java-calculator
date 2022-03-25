package com.prgrms.ndy;

import com.prgrms.ndy.domain.Calculation;
import com.prgrms.ndy.domain.Command;
import com.prgrms.ndy.io.ReaderWriter;
import com.prgrms.ndy.parsor.Parser;
import com.prgrms.ndy.repository.CalculationRepository;

import java.io.IOException;

public class Calculator {

    private final Parser parser;
    private final ReaderWriter rw;
    private final CalculationRepository repository;

    public Calculator(Parser parser, ReaderWriter rw, CalculationRepository repository) {
        this.parser = parser;
        this.rw = rw;
        this.repository = repository;
    }

    public void run() throws IOException {
        try {
            do {
                rw.write("1. 조회\n2. 계산\n\n선택 : ");
                String choice = rw.read();
                if (choice.equals("F")) {
                    break;
                }

                int type = getType(choice);
                if (type == 1) {
                    displayCalculation();
                } else if (type == 2) {
                    procCalculation();
                }
            } while (true);
        } finally {
            rw.close();
        }
    }

    private int getType(String choice) throws IOException {
        int type;
        try {
            type = resolveType(choice);
        } catch (IllegalArgumentException e) {
            rw.write("1 or 2 중에 입력해주세요.\n");
            return -1;
        }
        return type;
    }

    private int resolveType(String requestType) {
        int type = Integer.parseInt(requestType);
        if (type < 1 || type > 2) throw new IllegalArgumentException();
        return type;
    }

    private void displayCalculation() throws IOException {
        for (Calculation c : repository.findAll()) {
            rw.write(c.display() + "\n");
        }
    }

    private boolean procCalculation() throws IOException {
        Command command;
        Number result;
        try {
            command = parser.parse(rw.read());
            result = command.proc();
        } catch (IllegalArgumentException e) {
            rw.write("옳바른 계산식을 입력해주세요.\n");
            return false;
        } catch (ArithmeticException e) {
            rw.write("0 으로 나눌 수 없습니다.\n");
            return false;
        }
        rw.write(result + "\n\n");

        repository.save(new Calculation(command, result));
        return true;
    }
}
