package hyuk.view;

import hyuk.entity.LogDTO;
import hyuk.entity.Result;

public interface OutputView {

    void printMenu();

    void printResult(Result result);

    void printLogs(LogDTO logDTO);
}
