import io.Input;
import io.Output;
import model.Result;
import utils.InputValidation;

import java.util.ArrayList;
import java.util.List;

public class Calculator implements Runnable {

    private Input input;
    private Output output;
    private boolean go = true;

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {

        while (go) {
            String option = input.readWithPrompt("0. 종료\n1. 조회\n2. 계산\n\n선택 : ");

            if (!InputValidation.isValidatedOption(option)) {
                output.inputError("0, 1, 2 중에 하나를 선택하세요.");
                continue;
            }

            switch (option) {
                case "0":
                    go = false;
                    break;
                case "1":
                    List<Result> results = new ArrayList<>();
                    output.results(results);
                    break;
                case "2":
                    String problem = input.read();
                    if (!InputValidation.isValidatedMathProblem(problem)) {
                        output.inputError("잘못된 형식입니다.");
                        continue;
                    }
                    Result result = calculate(problem);
                    output.answer(result);
            }
        }
    }

    private Result calculate(String problem) {
        int answer = 0;
        return new Result(problem, answer);
    }
}
