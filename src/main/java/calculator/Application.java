package calculator;

import calculator.engine.ProcessController;
import calculator.engine.RunningState;

public class Application {
    public static void main(String[] args) {
        ProcessController processController = new ProcessController();
        processController.run(new RunningState(true));
    }
}
