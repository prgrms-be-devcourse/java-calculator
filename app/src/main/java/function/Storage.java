package function;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    Map<Integer, String> storage = new HashMap<>();

    public void store(String value) {
        storage.put(storage.size(), value);
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        int size = storage.size();

        for (int i = size - 1; i >= 0; i--) {
            sb.append(storage.get(i)).append("\n");
        }

        return sb.toString();
    }
}

