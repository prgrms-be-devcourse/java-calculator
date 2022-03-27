package src.log;

import java.util.List;


public interface LogRepository {
     void clear();
     void save(Log log);
     List<Log> findAll();
}
