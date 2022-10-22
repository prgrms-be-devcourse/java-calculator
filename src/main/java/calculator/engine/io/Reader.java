package calculator.engine.io;

import calculator.engine.io.enums.SelectOption;
import calculator.engine.model.UserSelection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Reader {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public UserSelection readSelection() {
        Integer inputNumber = readNumber();
        SelectOption selection = parseToSelectOption(inputNumber);
        return new UserSelection(selection);
    }

    private SelectOption parseToSelectOption(Integer inputNumber) {
        Optional<SelectOption> optionalSelectOption = Arrays.stream(SelectOption.values())
                .filter(selectOption -> selectOption.getIndex().equals(inputNumber))
                .findFirst();

        return optionalSelectOption.orElseThrow(NoSuchElementException::new);
    }

    private Integer readNumber() {
        // TODO: 입력 0, 1, 2를 제외한 숫자에 대한 예외처리 (parseToSelectOption 메서드에서 NSEE 로 잡히긴 하는데, 더 효율적으로 처리할 수 없을까..?)
        String inputLiteral = readLine();
        return Integer.valueOf(inputLiteral); // TODO: Integer.valueOf()의 예외 처리
    }

    private String readLine() { // TODO: 더 구체적인 예외처리
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
