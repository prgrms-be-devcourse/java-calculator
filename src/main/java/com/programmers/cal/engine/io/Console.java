package com.programmers.cal.engine.io;

import com.programmers.cal.engine.model.Answer;
import com.programmers.cal.engine.model.Record;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputOrder() {
        return scanner.nextLine();
    }

    @Override
    public void requestInput() {
        System.out.println(Message.MENU_MESSAGE);
    }

    @Override
    public void printWrongOrder() {
        System.out.println(Message.WRONG_ORDER_MESSAGE);
    }

    @Override
    public void printRecord(Record record) {
        record.getEquations().forEach(System.out::println);
    }

    @Override
    public void printResult(Answer answer) {
        System.out.println(answer.getAnswer());
    }

    @Override
    public void printExit() {
        System.out.println(Message.EXIT_MESSAGE);
    }

    @Override
    public void printZeroDivision() {
        System.out.println(Message.ZERO_MESSAGE);
    }

    @Override
    public void printNoRecord() {
        System.out.println(Message.NO_RECORD_MESSAGE);
    }
}
