package hyuk.view;

import hyuk.model.LogDTO;
import hyuk.model.ResultDTO;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    public void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
    }

    public void printResult(ResultDTO resultDTO) {
        System.out.println(resultDTO.getResult());
        System.out.println();
    }

    public void printLogs(LogDTO logDTO) {
        List<String> dtoLogs = logDTO.getLogs();
        dtoLogs.forEach(System.out::println);
        System.out.println();
    }

    public void printEmptySpace() {
        System.out.println();
    }
}
