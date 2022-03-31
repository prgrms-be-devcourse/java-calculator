package calculator.io;

import java.util.Map;

public interface Output {
    void answerPrint(int answer);

    void historyPrint(Map<String, Integer> store);
}
