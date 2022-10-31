package com.programmers.calculator.io;

import com.programmers.calculator.entity.Operation;
import com.programmers.calculator.storage.OperationStorage;

import java.util.Optional;
import java.util.Scanner;

public class Console{
    private Scanner sc = new Scanner(System.in);

    public String inputStr() {
        System.out.println("\n1. 조회\n2. 계산\n\n선택 : ");
        return sc.nextLine();
    }
    public void printNoOperation() {
        System.out.println("출력할 결과가 없습니다.");
    }
    public void printOperation(Operation result) {
        System.out.println(result);
    }
    public void printLastAllOperation(OperationStorage operationStorage) {
        long index = 0L;

        while (true) {
            Optional<Operation> data = operationStorage.findById(index++);
            if (data.isEmpty())
                break;

            printOperation(data.get());
        }
    }
}
