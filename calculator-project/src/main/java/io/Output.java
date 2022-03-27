package io;
import java.util.List;

public interface Output {
    void history(List<String> history);
    void result(Number number);
    void exit();
    void inputError();
    void menu();
}
