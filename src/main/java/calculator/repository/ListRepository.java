package calculator.repository;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements CalculationRepository {

    private final List<String> list = new ArrayList<>();

    @Override
    public String save(String command, Double result) {
        String resultData = command + " = " + String.valueOf(result);
        list.add(resultData);
        return resultData;
    }

    @Override
    public List<String> findAll() {
        return list;
    }
}

