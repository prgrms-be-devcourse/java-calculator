package calculator.engine.io;

import calculator.engine.model.CalculationDto;

import java.util.List;

public interface Output {
    void calcResultPrint(CalculationDto calculate);
    void selectAllCommand(List<String> all);
    void wrongInput();
    void ExceptionMessage(Exception e);
    void strangeCommand();
}
