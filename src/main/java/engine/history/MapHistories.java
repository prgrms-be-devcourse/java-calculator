package engine.history;

import java.util.HashMap;
import java.util.Map;

public class MapHistories implements Histories {
    private final Map<String, String> map = new HashMap<>();

    @Override
    public void save(String calculateSentence, String answer) {
        map.put(calculateSentence, answer);
    }

    @Override
    public Map<String, String> getHistories() {
        return map;
    }
}
