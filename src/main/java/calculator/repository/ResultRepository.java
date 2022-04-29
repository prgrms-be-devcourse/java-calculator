package calculator.repository;

public interface ResultRepository {

    // 계산한 적 있는지
    Boolean isCalculated(String expr);

    Integer getResult(String expr);

    void saveResult(String expr, Integer resultOfExpr);

    void printAll();

}
