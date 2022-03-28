package calculator.module.history;

import java.util.ArrayList;
import java.util.List;
/**
*
* MemoryCalculationHistoryManager 설명
*   계산 이력 조회 기능을 담당하는 클래스
*
**/
public class MemoryCalculationHistoryManager implements CalculationHistoryManager {
    private final List<CalculationHistory> calculationHistoryStore;
    private final static String HISTORY_NOT_EXIST_MESSAGE = "계산 이력이 없습니다.";

    public MemoryCalculationHistoryManager(){
        calculationHistoryStore = new ArrayList<>();
    }

    @Override
    public void printAllCalculationHistory() {
        if(calculationHistoryNotExist()){
            System.out.println(HISTORY_NOT_EXIST_MESSAGE);
        }
        else {
            printHistory();
        }
    }

    @Override
    public void saveCalculationResultToHistory(String expression, Double result) {
        calculationHistoryStore.add(new CalculationHistory(expression, result));
    }

    public boolean calculationHistoryNotExist(){
        return calculationHistoryStore.isEmpty();
    }

    private void printHistory(){
        calculationHistoryStore.forEach(System.out::println);
    }

}
