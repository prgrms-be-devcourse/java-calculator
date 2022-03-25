package calculator.repository;

import calculator.engine.model.CalculationDto;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements CalculationRepository {

    private final List<String> list = new ArrayList<>();

    @Override
    public void save(CalculationDto calculationDto) {
        list.add(calculationDto.toString());
    }

    @Override
    public List<String> findAll() {
        return list;
    }
}

