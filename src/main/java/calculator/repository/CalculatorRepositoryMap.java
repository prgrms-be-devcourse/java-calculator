package calculator.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class CalculatorRepositoryMap implements CalculatorRepository {
    private final Map<String, String> storage = new LinkedHashMap<>();
    public CalculatorRepositoryMap() {}

    public Map<String, String> getStorage() {
        return storage;
    }

    @Override
    public void save(String formula, String answer) {
        formula = formula.trim().replaceAll(" +", " ");

        storage.put(formula, answer);
    }

    @Override
    public String search() {
        if(storage.isEmpty()) {
            return "\n데이터가 존재하지 않습니다.\n";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        storage.keySet().forEach(key -> {
            sb.append(key).append(" = ").append(storage.get(key)).append("\n");
        });

        return sb.toString();
    }

    @Override
    public void clear() {
        storage.clear();
    }
}
