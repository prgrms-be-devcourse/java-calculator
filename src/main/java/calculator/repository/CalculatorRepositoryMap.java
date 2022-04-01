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
        StringBuilder sb = new StringBuilder();

        String[] form = formula.replaceAll(" ", "").split("");
        for(int i = 0; i < form.length; i++) {
            if(i < form.length - 1) {
                sb.append(form[i]).append(" ");
            } else {
                sb.append(form[i]);
            }
        }

        storage.put(sb.toString(), answer);
    }

    @Override
    public String search() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        if(storage.isEmpty()) {
            sb.append("데이터가 존재하지 않습니다.\n");
            return sb.toString();
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
