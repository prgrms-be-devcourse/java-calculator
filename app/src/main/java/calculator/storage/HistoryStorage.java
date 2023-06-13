package calculator.storage;

import java.util.ArrayList;
import java.util.List;

public class HistoryStorage {

    private final List<String> storage = new ArrayList<>();

    public void save(String history) {
        storage.add(history);
    }

    public String[] readAllHistory() {
        return storage.toArray(String[]::new);
    }
}
