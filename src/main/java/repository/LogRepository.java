package repository;

import java.util.List;

public interface LogRepository<T> {
    void save(T log);
    List<T> getAll();
}
