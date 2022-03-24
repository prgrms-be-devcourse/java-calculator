package repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository implements CalcRepository {
    private final List<String> memory = new ArrayList<>();
    private static InMemoryRepository instance;

    public static InMemoryRepository getInstance() {
        if (instance == null) instance = new InMemoryRepository();
        return instance;
    }

    private InMemoryRepository() {
    }

    @Override
    public void save(String expression, double result) {
        memory.add(expression + " = " + result);
    }

    @Override
    public String getResults() {

        StringBuilder sb = new StringBuilder();

        for (String s : memory) {
            sb.append(s).append("\n");
        }

        return sb.toString();
    }
}
