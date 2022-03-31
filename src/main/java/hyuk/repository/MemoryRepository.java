package hyuk.repository;

import hyuk.entity.Record;
import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {

    private List<Record> logs = new ArrayList<>();

    public void store(Record log) {
        logs.add(log);
    }

    public List<Record> getData() {
        return logs;
    }
}
