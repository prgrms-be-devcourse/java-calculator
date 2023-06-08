package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Storage;
import com.devcourse.java.domain.calculateResult.CalculateResult;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.validator.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class Query implements Menu {
    private final Storage<CalculateResult> storage;
    private final Validator validator;

    public Query(Storage<CalculateResult> storage, Validator validator) {
        this.storage = storage;
        this.validator = validator;
    }

    @Override
    public boolean execute(Console console) {
        List<CalculateResult> calculateResults = storage.fetchAll();
        queryResults(console, calculateResults);
        return true;
    }

    private void queryResults(Console console, List<CalculateResult> calculateResults) {
        if (validator.isNotEmpty(calculateResults, console)) {
            List<String> resultStrings = toString(calculateResults);
            console.printList(resultStrings);
        }
    }

    private List<String> toString(List<CalculateResult> calculateResults) {
        return calculateResults.stream()
                .map(CalculateResult::toString)
                .collect(Collectors.toList());
    }
}
