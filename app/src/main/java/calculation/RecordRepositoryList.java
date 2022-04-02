package calculation;

import java.util.LinkedList;
import java.util.List;

public class RecordRepositoryList<T> implements RecordRepository<T> {

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
