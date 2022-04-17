package calculator.engine.io;

import java.util.Map;

public interface Output {
    void calcResult(double result);     // 계산 결과 출력

    void calcHistory(Map<Integer, String> histories);      // 게산 이력 출력
}
