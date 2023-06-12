package com.devcourse.java.domain.menu;

import com.devcourse.java.domain.storage.Storage;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.common.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static com.devcourse.java.common.Messages.EMPTY_STORAGE;

public class Query implements Menu {
    private final Storage<CalculateResult> storage;

    public Query(Storage<CalculateResult> storage) {
        this.storage = storage;
    }

    @Override
    public boolean execute(Console console) {
        List<CalculateResult> calculateResults = storage.fetchAll();
        queryResults(console, calculateResults);
        return true;
    }

    private void queryResults(Console console, List<CalculateResult> calculateResults) {
        if (Validator.isNotEmpty(calculateResults)) {
            List<String> resultStrings = toString(calculateResults);
            console.printList(resultStrings);
        } else { // todo: change
            console.print(EMPTY_STORAGE.toMessage());
        }
    }

    private List<String> toString(List<CalculateResult> calculateResults) {
        return calculateResults.stream()
                .map(CalculateResult::toString)
                .collect(Collectors.toList());
    }
}
