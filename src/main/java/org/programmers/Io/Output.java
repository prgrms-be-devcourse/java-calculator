package org.programmers.Io;

import java.util.Map;

public interface Output {

    void printOption();
    void printExit();
    void printError(String errorMsg);
    void printCal(String result);
    void printQuery(Map<Long, String> query);
}
