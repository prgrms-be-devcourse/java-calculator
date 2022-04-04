package hyuk.view;

import hyuk.model.RecordsDTO;
import hyuk.model.ResultDTO;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    @Override
    public void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
    }

    @Override
    public void printResult(ResultDTO resultDTO) {
        System.out.println(resultDTO.getResult());
        System.out.println();
    }

    @Override
    public void printRecords(RecordsDTO recordsDTO) {
        List<String> stringRecords = recordsDTO.getStringRecords();
        stringRecords.forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void printEmptySpace() {
        System.out.print(System.lineSeparator());
    }

    @Override
    public void printException(Exception e) {
        System.out.println(e.getMessage() + "\n");
    }
}
