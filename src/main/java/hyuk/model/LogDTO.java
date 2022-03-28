package hyuk.model;

import hyuk.entity.Log;
import java.util.List;
import java.util.stream.Collectors;

public class LogDTO {

    private List<String> stringLogs;

    public LogDTO(List<Log> logs) {
        stringLogs = logs.stream().map(Log::toString)
            .collect(Collectors.toList());
    }

    public List<String> getLogs() {
        return stringLogs;
    }
}
