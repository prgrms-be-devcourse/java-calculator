package repository;

import model.CalculationLog;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static view.OutputView.*;

public class CalculationLogRepositoryImpl implements CalculationLogRepository {
    private static final Map<Long, CalculationLog> repository = new TreeMap<>(Comparator.naturalOrder());
    private static long index = 0L;

    @Override
    public void viewLog() {
        printLogs(repository);
    }

    @Override
    public void save(final CalculationLog cl) {
        repository.put(index++, cl);
    }
}
