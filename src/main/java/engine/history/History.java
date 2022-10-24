package engine.history;

public interface History {
    void save(String calculation, String answer);
    String getAll();
}
