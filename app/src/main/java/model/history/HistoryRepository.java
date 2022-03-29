package model.history;


import java.util.List;

public interface HistoryRepository<T> {

	List<T> findAllRecord();

	void addRecord(T record);
}
