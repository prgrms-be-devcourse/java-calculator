package calculator;

import calculator.controller.ProcessController;
import calculator.controller.RunningState;

public class Application {
    public static void main(String[] args) {
        ProcessController processController = new ProcessController();
        processController.run(new RunningState(true));
    }
}
