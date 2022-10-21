package calculator.engine;

import calculator.io.Console;

public class ProcessController {
    private final Console console;

    public ProcessController() {
        this.console = new Console();
    }

    public void run(RunningState runningState) {
        while (runningState.isRunning()) {
            // TODO: 계산, 조회 입력 받기
            console.getUserSelection();
            break;
        }
    }
}
