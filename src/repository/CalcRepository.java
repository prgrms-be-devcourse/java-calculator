package repository;

import java.math.BigDecimal;

public interface CalcRepository {
    void save(String expression, BigDecimal result);
    void save(String expression, Long result);
    void save(String expression, String result);
    String getAll();
}
