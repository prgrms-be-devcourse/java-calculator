package Record;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecordMemoryRepository implements RecordRepository {

    private Map<Long, Record> recordMap = new LinkedHashMap();
    private long ID_COUNT = 0L;

    @Override
    public void save(Record record) {
        synchronized (this) {
            recordMap.put(++ID_COUNT, record);
        }
    }

    @Override
    public Map<Long, Record> findAll() {
        return recordMap;
    }
}
