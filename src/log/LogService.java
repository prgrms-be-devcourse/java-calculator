package src.log;

import java.util.List;

/**
 * -> 의존관계
 * => 인터페이스 구현
 * Logger -> LogDB <= MemoryLogDB
 */
public class LogService {
    private final LogRepository logDB;

    public LogService(LogRepository logDB) {
        this.logDB = logDB;
    }

    public void save(Log log) {
        logDB.save(log);
    }
    public List<Log> findAll(){
        return logDB.findAll();
    }

}
