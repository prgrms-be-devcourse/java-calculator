package repository;

public interface CalcRepository {
    void save(String expression, double result);

    String getResults();
}
