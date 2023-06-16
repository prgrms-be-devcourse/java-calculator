package org.example.Output;

import java.util.List;

public interface Show {
    void showMenu();

    void showRecords(List<String> records);

    void showResult(int result);

    void lineBreak();

    void showInvalidInput();
}
