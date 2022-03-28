package hyuk.view;

import hyuk.entity.LogDTO;
import hyuk.entity.Result;
import java.util.List;

public class ConsoleOutputView implements OutputView {

    public void printMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");
    }

    public void printResult(Result result) {
        System.out.println(result.showResult());
    }

    public void printLogs(LogDTO logDTO) {
        List<String> logs = logDTO.getLogs();

        logs.forEach((log) -> System.out.println(log));
        System.out.println();
    }
}
