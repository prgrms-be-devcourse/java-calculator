package model.history;

import java.util.LinkedList;
import java.util.List;

public class HistoryRepositoryList<T> implements HistoryRepository<T> {

	private LinkedList<T> list = new LinkedList<>();

	@Override
	public List<T> findAllRecord() {
		return list;
	}

	@Override
	public void addRecord(T record) {
		list.add(record);
	}
}
