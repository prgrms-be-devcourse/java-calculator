package hyuk.view;

import hyuk.model.RecordsDTO;
import hyuk.model.ResultDTO;

public interface OutputView {

    void printMenu();

    void printResult(ResultDTO resultDTO);

    void printRecords(RecordsDTO logDTO);

    void printEmptySpace();

    void printException(Exception e);
}
