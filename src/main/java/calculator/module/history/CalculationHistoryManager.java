package calculator.module.history;

/**
*
* CalculationResultHistoryManager 설명
* 계산 이력 조회 기능을 추상화한 인터페이스*
**/

public interface CalculationHistoryManager {
    void printAllCalculationHistory();
    void saveCalculationResultToHistory(String expression, CalculationHistory history);
}
