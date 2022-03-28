package hyuk.repository;

import hyuk.entity.Log;
import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {

    private List<Log> logs = new ArrayList<>();

    public void store(Log log) {
        logs.add(log);
    }

    public List<Log> getData() {
        return logs;
    }
}
