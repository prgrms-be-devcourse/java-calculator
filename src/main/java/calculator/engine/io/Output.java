package calculator.engine.io;

import java.util.ArrayList;

public interface Output {
    void calcResult(double result);     // 계산 결과 출력

    void calcHistory(ArrayList<String> histories);      // 게산 이력 출력
}
