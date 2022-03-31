package hyuk.model;

import hyuk.entity.Record;
import java.util.List;
import java.util.stream.Collectors;

public class RecordsDTO {

    private List<String> stringRecords;

    public RecordsDTO(List<Record> records) {
        stringRecords = records.stream()
            .map(Record::toString)
            .collect(Collectors.toList());
    }

    public List<String> getStringRecords() {
        return stringRecords;
    }
}
