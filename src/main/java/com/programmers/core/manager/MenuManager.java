package com.programmers.core.manager;

import com.programmers.core.data.CalculationResult;
import com.programmers.error.ErrorMessages;
import com.programmers.view.Console;

import java.util.List;

public class MenuManager {

    private final Console console;

    public MenuManager(Console console) {
        this.console = console;
    }

    public String inputMenu() {
        return console.inputMenu();
    }

    public void printInvalidMenuSelection() {
        console.print(ErrorMessages.getInvalidMenuSelectionMsg());
    }

    public void printExitMessage() {
        console.print("프로그램을 종료합니다.");
    }

    public void printCalculationRecords(List<CalculationResult> calculationRecord) {
        if (calculationRecord.isEmpty()) {
            console.print(ErrorMessages.getNoCalculationRecordsMsg());
        } else {
            console.printList(calculationRecord);
        }
    }
}

