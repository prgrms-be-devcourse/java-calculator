package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String choice = "";
        AppConfig appConfig = new AppConfig();
        Calculator calculator = new Calculator(appConfig.input(), appConfig.output(),
                appConfig.parser(), appConfig.calculate(), appConfig.expressRepository());

        while (!choice.equals("3")){
            calculator.out.menu();
            choice = calculator.input.read();
            switch (choice) {
                case "1" -> {calculator.history();}
                case "2" -> {
                    calculator.execute(calculator.input.read());
                }
                case "3" -> {
                    System.out.println("프로그램 종료");
                }
                default -> {
                    System.out.println("잘못된 값을 입력했습니다. (숫자로 입력해주세요)");
                }
            }
        }
    }
}
