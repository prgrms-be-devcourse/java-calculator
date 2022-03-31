package hyuk.repository;

import hyuk.entity.Record;
import java.util.HashMap;
import java.util.Map;

public class MemoryRepository implements Repository {

    private static long SEQUENCE = 0;
    private Map<Long, Record> records = new HashMap<>();

    @Override
    public void store(Record record) {
        record.setId(++SEQUENCE);
        records.put(record.getId(), record);
    }

    @Override
    public Integer getRecordsSize() {
        return records.size();
    }

    @Override
    public Record findById(Long id) {
        return records.get(id);
    }

    @Override
    public void removeAll() {
        records.clear();
        SEQUENCE = 0;
    }
}
