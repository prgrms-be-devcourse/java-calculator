package hyuk.model;

import hyuk.entity.Record;
import java.util.List;
import java.util.stream.Collectors;

public class LogDTO {

    private List<String> stringLogs;

    public LogDTO(List<Record> logs) {
        stringLogs = logs.stream()
            .map(Record::toString)
            .collect(Collectors.toList());
    }

    public List<String> getLogs() {
        return stringLogs;
    }
}
