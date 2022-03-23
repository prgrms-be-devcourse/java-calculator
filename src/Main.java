import config.AppConfig;
import repository.ListRepository;
import service.CalculationImpl;
import service.CalculationService;
import service.CalculationServiceImpl;
import service.CommandFilterImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        CalculationService calculationService = config.calculationService();
        try {
            while (true) {
                System.out.println("1. 조회\n2. 계산\n3. 종료");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int n = Integer.valueOf(br.readLine());
                if (n == 1) {
                    calculationService.findAll();
                } else if (n == 2) {
                    String command = br.readLine();
                    System.out.println(command);
                    calculationService.calculate(command);
                } else if (n == 3) {
                    break ;
                } else
                    throw new RuntimeException("N must be 1 ~ 3");
            }
        } catch (Exception e) {
            System.out.printf(ANSI_RED + "[Error]: %s\n", e.getMessage());
        }
    }
}
