package engine.repository;

import java.util.*;

public class CalculatorRepository implements Repository<Integer, String> {

    private int size = 0;
    private final Map<Integer, String> map;


    public CalculatorRepository() {
        map = new LinkedHashMap<>();
    }

    //(key : formula, value : answer)
    public void save(String value) {
        size++;
        map.put(size, value);
    }

    public List<String> findAllValues() {
        List<String> valueList = new ArrayList<>(map.values());
        return valueList;
    }

}
