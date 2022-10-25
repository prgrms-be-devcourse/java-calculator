package com.programmers.java.engine.option;


import com.programmers.java.application.Console;
import com.programmers.java.engine.history.HistoryRepository;
import com.programmers.java.engine.model.Equation;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class HistoryOption implements Option {
    private Console console;
    private HistoryRepository historyRepository;

    @Override
    public void runOption() {
        List<Equation> historyRepositoryAll = historyRepository.findAll();

        console.printHistory(historyRepositoryAll);
    }
}
