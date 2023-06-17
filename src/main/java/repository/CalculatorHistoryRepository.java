package repository;

import java.util.ArrayList;
import java.util.List;

public class CalculatorHistoryRepository implements Repository {
    private static final List<String> repository = new ArrayList<>();
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void inquiry() {
        repository.forEach(System.out::println);
    }

    @Override
    public void save(String record, int result) {
        sb.setLength(0);
        sb.append(record);
        sb.append("=");
        sb.append(result);

        repository.add(sb.toString());
    }
}
