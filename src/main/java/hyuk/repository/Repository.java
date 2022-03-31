package hyuk.repository;

import hyuk.entity.Record;
import java.util.List;

public interface Repository {

    void store(Record log);

    List<Record> getData();
}
