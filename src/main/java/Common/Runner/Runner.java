package Common.Runner;

import Common.Exception.WrongValueException;
import Domain.Execution.Execution;
import Domain.Execution.Option;
import View.InputView;

public class Runner implements Runnable {
    private final InputView view = new InputView();
    private final int MAX_COUNT = 3;

    @Override
    public void run() {
        int stageNumber = 0;
        while (stageNumber < MAX_COUNT) {
            int choice = -1;
            try {
                choice = view.getChoice();
            } catch (WrongValueException e) {
                view.wrongInput();
                continue;
            }
            Option option = Option.from(choice);
            Execution execution = option.convert();
            if (!execution.execute()) {
                view.wrongInput();
                continue;
            }
            stageNumber++;
        }
    }
}
