package calculator.application.io;

import java.util.List;

public interface Output {

    void logHistory(List<String> history);

    void logResult(String result);

    void logExit();
}
