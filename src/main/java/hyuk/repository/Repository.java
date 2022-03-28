package hyuk.repository;

import hyuk.entity.Log;
import java.util.List;

public interface Repository {

    void store(Log log);

    List<Log> getData();
}
