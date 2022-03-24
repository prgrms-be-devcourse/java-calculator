package repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements CalcRepository {
    private static final List<String> memory = new ArrayList<>();

    public InMemoryRepository() {
    }

    @Override
    public void save(String expression, BigDecimal result) {
        memory.add(expression + " = " + result);
    }

    @Override
    public void save(String expression, Long result) {
        memory.add(expression + " = " + result);
    }

    @Override
    public String getAll() {

        StringBuilder sb = new StringBuilder();

        for (String s : memory) {
            sb.append(s).append("\n");
        }

        return sb.toString();
    }
}
