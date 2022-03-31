package calculator.io;

import java.util.Map;

public interface Output {
    void answerPrint(int answer);

    void historyPrint(String exp, int answer);

    void menu();
}
