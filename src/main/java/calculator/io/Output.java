package calculator.io;

import java.util.Map;

public interface Output {
    void answerPrint(int answer);

    void historyPrintFormat(String exp, int answer);

    void menu();
}
