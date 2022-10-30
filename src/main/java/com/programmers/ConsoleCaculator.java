package com.programmers;

import com.programmers.caculation.CaculationController;
import com.programmers.config.AppConfig;
import com.programmers.io.Console;
import com.programmers.record.RecordController;

public class ConsoleCaculator {
    private boolean exitSign = false;

    Console console = AppConfig.myConsole;
    RecordController recordController = AppConfig.recordController;
    CaculationController caculationController = AppConfig.caculationController;

    public void start() {
        while (!exitSign) {
            console.showMenu();
            String userInput = console.getinputWithPrompt("선택 :");
            excuteByUserInput(userInput);
        }
    }

    private void excuteByUserInput(String userInput) {
        Menu inputMenu =Menu.getMenu(userInput);
        switch (inputMenu) {
            case RECORD -> recordLogic();
            case CACULATION -> calculationLogic();
            case EXIT -> exitLogic();
            default -> wrongInputLogic();

        }
    }

    private void wrongInputLogic() {
        console.showError(new Exception("잘못된 입력입니다.[1,2,3]중 1개를 입력해 주세요"));
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
        this.exitSign = true;
    }
}
