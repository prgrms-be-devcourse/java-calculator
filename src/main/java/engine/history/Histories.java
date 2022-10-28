package engine.history;

public interface Histories {
    void save(String calculateSentence, String answer);

    String convertToString();
}
