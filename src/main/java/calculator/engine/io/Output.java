package calculator.engine.io;

import java.util.LinkedHashMap;

public interface Output {
    void printCalculator(int result);
    void consoleMenu();
    void MemoryCalculator(LinkedHashMap<Integer, String> memoryCalculator);
    void outputError();
}