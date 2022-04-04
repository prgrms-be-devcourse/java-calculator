package hyuk.repository;

import hyuk.entity.Record;

public interface Repository {

    void store(Record record);

    Integer getRecordsSize();

    Record findById(Long id);

    void removeAll();
}
