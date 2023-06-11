package calculator.domain.repository;

import calculator.domain.model.HistoryModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorRepository {
    private final Map<Long, HistoryModel> calculatorRepository = new HashMap<>();
    private final IdGenerator idGenerator = IdGenerator.getInstance();

    public CalculatorRepository() {
    }

    public void save(HistoryModel history) {
        calculatorRepository.put(idGenerator.generateId(), history);
    }

    public List<HistoryModel> findAll() {
        return new ArrayList<>(calculatorRepository.values());
    }
}
