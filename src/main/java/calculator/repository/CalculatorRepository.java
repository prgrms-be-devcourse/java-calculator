package calculator.repository;

public interface CalculatorRepository {
    void save(String formula, String answer);
    String search();
    void clear();
}
