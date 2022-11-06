package engine.history;

public interface Histories<T> {
    void save(String calculateSentence, String answer);

    T getHistories();
}
