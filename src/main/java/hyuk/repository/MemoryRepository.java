package hyuk.repository;

import hyuk.entity.Record;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryRepository implements Repository {

    private final AtomicLong SEQUENCE = new AtomicLong(1);
    private final Map<Long, Record> records = new HashMap<>();

    @Override
    public void store(Record record) {
        record.setId(SEQUENCE.getAndIncrement());
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
        SEQUENCE.set(1);
    }
}
