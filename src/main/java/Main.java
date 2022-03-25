import config.AppConfig;
import service.CalculationService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        CalculationService calculationService = config.calculationService();
        try {
            while (true) {
                System.out.println("1. 조회\n2. 계산\n3. 종료");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.valueOf(br.readLine());
                if (n == 1) {
                    System.out.println(calculationService.findAll());
                } else if (n == 2) {
                    String command = br.readLine();
                    System.out.println(command);
                    System.out.println(calculationService.calculate(command));
                } else if (n == 3) {
                    break ;
                } else {
                    System.out.println(ANSI_RED + "N must be 1 ~ 3" + ANSI_RESET);
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.printf(ANSI_RED + "[Error]: %s\n", e.getMessage() + ANSI_RESET);
        }
    }
}
