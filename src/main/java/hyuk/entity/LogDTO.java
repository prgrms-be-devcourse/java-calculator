package hyuk.entity;

import java.util.List;

public class LogDTO {

    private List<String> logs;

    public LogDTO(List<String> asList) {
        logs = asList;
    }

    public List<String> getLogs() {
        return logs;
    }
}
