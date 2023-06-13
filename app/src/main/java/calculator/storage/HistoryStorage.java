package calculator.storage;

import java.util.ArrayList;
import java.util.List;

public class HistoryStorage {

    private final List<String> storage = new ArrayList<>();

    public void save(String history) {
        storage.add(history);
        System.out.println(storage);
    }
}
