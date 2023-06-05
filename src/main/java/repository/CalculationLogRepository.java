package repository;

import model.CalculationLog;

public interface CalculationLogRepository {

    void viewLog();
    void save(final CalculationLog cl);
}
