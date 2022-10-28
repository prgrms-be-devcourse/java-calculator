package com.programmers;

import com.programmers.caculation.CaculateService;
import com.programmers.caculation.CaculationController;
import com.programmers.caculation.ParseService;
import com.programmers.caculation.TokenizeService;
import com.programmers.caculation.caculator.PostfixCaculator;
import com.programmers.caculation.parser.PostfixParser;
import com.programmers.io.Console;
import com.programmers.record.RecordController;
import com.programmers.repository.HistoryRepository;
import com.programmers.repository.MemoryRepository;

public class ConsoleCaculator {
    Console console = new Console();
    HistoryRepository historyRepository = new MemoryRepository();
    RecordController recordController = RecordController.builder().historyRepository(historyRepository).build();
    CaculationController caculationController = CaculationController.builder()
            .caculateService(new CaculateService(new PostfixCaculator()))
            .parseService(new ParseService(new PostfixParser()))
            .historyRepository(historyRepository)
            .tokenizeService(new TokenizeService()).build();

    public void start() {
        while (true) {
            console.showMenu();
            String userInput = console.getinputWithPrompt("선택 :");
            excuteByUserInput(userInput);
        }
    }

    private void excuteByUserInput(String userInput) {
        switch (userInput) {
            case "1" -> {
                recordLogic();
            }
            case "2" -> {
                calculationLogic();
            }
            case "3" -> {
                exitLogic();
            }
            default -> {
                console.showError(new Exception("잘못된 입력입니다.[1,2,3]중 1개를 입력해 주세요"));
            }
        }
    }

    private void recordLogic() {
        console.showRecord(recordController.loadRecordData());
    }

    private void calculationLogic() {
        try {
            String input = console.getinputWithPrompt("식을 입력해주세요 :");
            console.showCaculateResult(caculationController.caculate(input));
        } catch (Exception e) {
            console.showError(e);
        }
    }
    private void exitLogic() {
        System.exit(0);
    }
}
