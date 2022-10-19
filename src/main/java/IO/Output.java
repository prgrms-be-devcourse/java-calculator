package IO;

import Record.Record;
import Result.ErrorCode;

import java.util.Map;

public interface Output {
    void showMenu();
    void output(String s);
    void allCalcRecord(Map<Long, Record> map);
    void errorPrint(ErrorCode errorCode);
}
