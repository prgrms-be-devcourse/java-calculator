package src.log;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;


public class MemoryLogDB implements LogDB {
    /**
     * 멀티스레딩 & 병렬처리(성능 개선)
     */
    private static final Queue<Log> store = new ConcurrentLinkedQueue<>();

    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public void save(Log log) {
        store.add(log);
    }

    @Override
    public List<Log> findAll() {
        return store.stream().collect(Collectors.toList());
    }
}
