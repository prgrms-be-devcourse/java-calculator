package calculator.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorRepository implements ICalculatorRepository {
    private final Map<String, String> storage = new LinkedHashMap<>();
    public CalculatorRepository() {}

    public Map<String, String> getStorage() {
        return storage;
    }

    @Override
    public void save(String formula, String answer) {
        storage.put(formula, answer);
    }

    @Override
    public String search() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        if(storage.isEmpty()) {
            return "데이터가 존재하지 않습니다.\n";
        }

        for (Map.Entry<String, String> items : storage.entrySet()) {
            String formula = items.getKey();
            String answer = items.getValue();

            sb.append(formula).append(" = ").append(answer).append("\n");
        }

        return sb.toString();
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
