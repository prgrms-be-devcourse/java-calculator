package Record;

import lombok.Getter;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@ToString
public class Record {

    private String express;
    private LocalDateTime localDateTime;

    public Record(String express) {
        this.express = express;
        this.localDateTime = LocalDateTime.now();
    }
}
