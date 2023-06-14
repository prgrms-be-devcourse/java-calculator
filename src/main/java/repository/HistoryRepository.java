package main.java.repository;

import main.java.domain.History;

import java.util.List;

public interface HistoryRepository {
    void saveHistory(History history);
    List<History> getAllHistoryToList();
}
