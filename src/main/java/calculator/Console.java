package calculator;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.model.CalculationDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Console implements Input, Output {

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final String ANSI_RED = "\u001B[31m";
    public final String ANSI_RESET = "\u001B[0m";

    @Override
    public String input(String prompt) {
        if (prompt != null && !prompt.equals("")) {
            System.out.println(prompt);
        }
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void calcResultPrint(CalculationDto calculate) {
        System.out.println(calculate);
    }

    @Override
    public void selectAllCommand(List<String> all) {
        all.stream().forEach((s) -> System.out.println(s));
    }

    @Override
    public void wrongInput() {
        redPrint("N must be 1 ~ 3");
    }

    @Override
    public void ExceptionMessage(Exception e) {
        redPrint("[Error]: " +  e.getMessage());
    }

    @Override
    public void strangeCommand() {
        redPrint("Strange command");
    }

    private void redPrint(String msg) {
        System.out.println(ANSI_RED + msg + ANSI_RESET);
    }
}
