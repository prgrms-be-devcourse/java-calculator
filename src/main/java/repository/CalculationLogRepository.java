package repository;

import model.CalculationLog;

public interface CalculationLogRepository {

    void loadAllLogs();
    void save(final CalculationLog cl);
}
