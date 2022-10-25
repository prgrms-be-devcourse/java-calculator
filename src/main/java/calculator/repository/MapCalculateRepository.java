package calculator.repository;

import calculator.dto.Calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapCalculateRepository implements CalculateRepository{

    //id가 약간 불필요해보입니다.
    private int id;
    private final Map<Integer, Calculation> mapCalculate;

    public MapCalculateRepository(){
        id = 0;
        mapCalculate = new HashMap<>();
    }

    @Override
    public void save(Calculation calculation) {
        mapCalculate.put(id, calculation);
        id++;
    }

    @Override
    public List<Calculation> findAll() {
        return new ArrayList<>(mapCalculate.values());
    }
}
