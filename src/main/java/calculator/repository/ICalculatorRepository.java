package calculator.repository;

public interface ICalculatorRepository {
    void save(String formula, String answer);
    String search();
    void clear();
}
