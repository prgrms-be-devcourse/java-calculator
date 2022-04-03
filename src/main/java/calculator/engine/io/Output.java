package calculator.engine.io;

import java.util.List;

public interface Output {
    void calcResultPrint(String saveData);
    void selectAllCommand(List<String> all);
    void wrongInput();
    void ExceptionMessage(Exception e);
    void strangeCommand();
}
