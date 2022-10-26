package engine.history;

public interface History {
    void save(String calculateSentence, String answer);

    String convertToString();
}
