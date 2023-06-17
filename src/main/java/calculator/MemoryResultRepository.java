package calculator;

import calculator.model.Result;
import calculator.respository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryResultRepository implements Repository {

    Map<Integer, Result> storeMap = new HashMap<>();
    int idx = 0;

    @Override
    public void save(Result result) {
        storeMap.put(idx++, result);
    }

    @Override
    public List<Result> findAll() {
        return storeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

}
