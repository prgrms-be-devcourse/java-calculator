package repository;

import model.CalculationLog;

public interface CalculationLogRepository {

    void checkLog();
    void save(final CalculationLog cl);
}
