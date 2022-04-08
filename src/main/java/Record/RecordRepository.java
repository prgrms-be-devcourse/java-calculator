package Record;

import java.util.Map;

public interface RecordRepository {

    void save(Record record);

    Map<Long, Record> findAll();
}
