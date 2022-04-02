package calculation;


import java.util.List;

public interface RecordRepository<T> {

	List<T> findAllRecord();

	void addRecord(T record);
}
