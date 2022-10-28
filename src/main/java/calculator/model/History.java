package calculator.model;

public interface History {
    void getHistory(String key);
    void historyList();
    void addHistory(String key, String value);
    boolean isContainsKey(String s);
}
