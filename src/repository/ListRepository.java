package repository;

import domain.CalculationDto;

import java.util.ArrayList;
import java.util.List;

public class ListRepository implements CalculationRepository {

    private final List<String> list = new ArrayList<>();

    @Override
    public void save(CalculationDto calculationDto) {
        list.add(calculationDto.getCommand() + " = " + calculationDto.getResult());
    }

    @Override
    public List<String> findAll() {
        return null;
    }
}

