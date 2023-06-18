package com.devcourse.java.domain.menu;

import com.devcourse.java.common.Validator;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.storage.CalculateResult;
import com.devcourse.java.domain.storage.Storage;

import java.util.List;
import java.util.stream.Collectors;

public class Query implements Menu {
    private static final String EMPTY_STORAGE = "계산 이력이 없습니다.\n\n";
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
            console.write(resultStrings);
            return;
        }

        console.write(EMPTY_STORAGE);
    }

    private List<String> toString(List<CalculateResult> calculateResults) {
        return calculateResults.stream()
                .map(CalculateResult::toString)
                .collect(Collectors.toList());
    }
}
