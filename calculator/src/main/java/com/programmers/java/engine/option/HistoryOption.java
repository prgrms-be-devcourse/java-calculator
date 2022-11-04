package com.programmers.java.engine.option;


import com.programmers.java.application.Console;
import com.programmers.java.engine.history.HistoryRepository;
import com.programmers.java.engine.model.EquationRecord;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HistoryOption implements Option {
    private Console console;
    private HistoryRepository historyRepository;

    @Override
    public void runOption() {
        EquationRecord record = historyRepository.findAll();

        console.printHistory(record);
    }
}
