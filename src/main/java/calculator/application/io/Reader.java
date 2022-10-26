package calculator.application.io;

import calculator.application.io.enums.SelectOption;
import calculator.application.model.UserSelection;
import calculator.engine.model.Expression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Reader {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public UserSelection readSelection() {
        Integer inputNumber = readNumber();
        SelectOption selection = parseToSelectOption(inputNumber);
        return new UserSelection(selection);
    }

    public Expression readExpression() {
        String expressionLiteral = readLine();
        List<String> expression = Parser.toList(expressionLiteral);
        return new Expression(expression);
    }

    private SelectOption parseToSelectOption(Integer inputNumber) {
        Optional<SelectOption> optionalSelectOption = Arrays.stream(SelectOption.values())
                .filter(selectOption -> selectOption.getIndex().equals(inputNumber))
                .findFirst();

        return optionalSelectOption.orElseThrow(NoSuchElementException::new);
    }

    private Integer readNumber() {
        String inputLiteral = readLine();
        return Integer.valueOf(inputLiteral);
    }

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
