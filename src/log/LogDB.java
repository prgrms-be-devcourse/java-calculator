package src.log;

import java.util.List;


public interface LogDB {
     void clear();
     void save(Log log);
     List<Log> findAll();
}
