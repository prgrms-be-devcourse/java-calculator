package calulator.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpressionRepository {

    private static final LinkedHashMap<String, String> repository = new LinkedHashMap<>();

    public void addExpression(String expression, String result) {
        repository.put(expression, result);
    }

    public List<String> resultsToList() {
        List<String> results = new ArrayList<>();
        repository.entrySet().stream()
                .forEach(e -> results.add(e.getKey() + " = " + e.getValue()));

        return results;
    }

}
