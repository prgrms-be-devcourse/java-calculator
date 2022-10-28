package engine.history;

import java.util.Map;

public interface Histories <T>{
    void save(String calculateSentence, String answer);

    T getHistories();
}
