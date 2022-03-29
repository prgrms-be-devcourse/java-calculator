package repository;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryRepository implements CalcRepository  {
    private final Map<Long, String> memory = new LinkedHashMap<>();
    private static Long sequence = 0L;

    public InMemoryRepository() {
    }

    @Override
    public void save(String expression, BigDecimal result) {
        memory.put(sequence++, expression + " = " + result);
    }

    @Override
    public void save(String expression, Long result) {
        memory.put(sequence++, expression + " = " + result);
    }

    @Override
    public void save(String expression, String result) { memory.put(sequence++, expression + " = " + result); }

    @Override
    public String getAll() {

        StringBuilder sb = new StringBuilder();

        for (String value : memory.values()) {
            sb.append(value).append("\n");
        }

        return sb.toString();
    }
}
