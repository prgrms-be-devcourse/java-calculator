package calculator;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);
    private static final Validation validation = new Validation();
    @Override
    public int selectConsoleNumber() {
        int selectNumber = scanner.nextInt();
        try{
            return validation.checkConsoleNumber(selectNumber);
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        return selectNumber;
    }
    @Override
    public String inputCalculator() {
        scanner.nextLine();
        String initString = scanner.nextLine();
        return initString;
    }
    @Override
    public void MemoryCalculator(LinkedHashMap<Integer, String> memoryCalculator) {
        memoryCalculator.values().forEach(System.out::println);
    }
    @Override
    public void outputError() {
        System.out.println("프로그램 오류가 발생하였습니다.");
    }
    @Override
    public void consoleMenu() {
        System.out.println("1. 조회");
        System.out.println("2. 계산\n");
        System.out.print("선택: ");
    }
    @Override
    public void printCalculator(int result) {
        System.out.println(result);
    }
}