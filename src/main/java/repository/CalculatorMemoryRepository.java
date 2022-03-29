package repository;

import entity.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculatorMemoryRepository implements CalculatorRepository{
    private static HashMap<Long, Data> store = new HashMap<>();

    @Override
    public String save(Data data) {
        store.put(data.getId(), data);
        return store.get(data.getId()).getResult();
    }

    @Override
    public Data findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Data> findAll() {
        List<Data> list = new ArrayList<>();

        store.keySet()
                .stream()
                .sorted()
                .forEach((k) -> list.add(store.get(k)));

        return list;
    }

    @Override
    public void clear() {
        store.clear();
    }
}
