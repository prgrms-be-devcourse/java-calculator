package hyuk.view;

import hyuk.model.LogDTO;
import hyuk.model.Result;

public interface OutputView {

    void printMenu();

    void printResult(Result result);

    void printLogs(LogDTO logDTO);

    void printEmptySpace();
}
