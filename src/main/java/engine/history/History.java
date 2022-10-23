package engine.history;

public interface History {
    void save(String calculation, int answer);
    String getAll();
}
