package com.programmers.calculator.io;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.storage.OperationStorage;

import java.util.Optional;
import java.util.Scanner;

public class Console{
    private Scanner sc = new Scanner(System.in);

    public String inputStr() {
        return sc.nextLine();
    }
    public void printString(String str) {
        System.out.print(str);
    }
    public void printlnString(String str) {
        System.out.println(str);
    }
    public void printNoOperation() {
        System.out.println("출력할 결과가 없습니다.");
    }
    public void printOperation(Operation result) {
        System.out.println(result);
    }
    public void printHistory(OperationStorage operationStorage) {
        long index = 0L;

        while (true) {
            Optional<Operation> data = operationStorage.findById(index++);
            if (data.isEmpty())
                break;

            printOperation(data.get());
        }
    }
}
