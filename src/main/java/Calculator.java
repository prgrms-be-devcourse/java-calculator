import io.Input;
import io.Output;
import model.Result;
import repository.Repository;
import utils.InputValidation;

import java.util.ArrayList;

public class Calculator implements Runnable {

    private Input input;
    private Output output;
    private Repository repository;
    private boolean go = true;

    public Calculator(Input input, Output output, Repository repository) {
        this.input = input;
        this.output = output;
        this.repository = repository;
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
                    output.results(repository.findAll());
                    break;
                case "2":
                    String problem = input.read();
                    if (InputValidation.isValidatedMathProblem(problem)) {
                        Result result = calculate(problem);
                        repository.save(result);
                        output.answer(result);
                    }
                    else {
                        output.inputError("잘못된 형식입니다.");
                    }
            }
        }
    }

    private Result calculate(String problem) {
        int answer = 0;
        return new Result(problem, answer);
    }
}
