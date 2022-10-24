package engine.history;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class MapHistory implements History {
    private Map<String, String> map = new HashMap<>();
    private StringBuilder sb = new StringBuilder();

    @Override
    public void save(String calculation, String answer) {
        map.put(calculation, answer);
    }

    @Override
    public String getAll() {
        for (String s : map.keySet()) {
            sb.append(s+" = ").append(map.get(s)).append('\n');
        }

        return sb.toString();
    }

    public Map<String, String> getMap() {
        return map;
    }
}
