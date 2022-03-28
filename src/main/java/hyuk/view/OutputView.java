package hyuk.view;

import hyuk.model.LogDTO;
import hyuk.model.ResultDTO;

public interface OutputView {

    void printMenu();

    void printResult(ResultDTO resultDTO);

    void printLogs(LogDTO logDTO);

    void printEmptySpace();
}
