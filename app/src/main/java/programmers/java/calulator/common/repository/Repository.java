package programmers.java.calulator.common.repository;

import java.util.List;

public interface Repository {
    void save(History history);
    List<History> findAll();
}
