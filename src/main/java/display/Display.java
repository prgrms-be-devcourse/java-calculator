package display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Display {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        while (true) {
            System.out.println(Message.DISPLAY_SELECT.getMessage());
            System.out.println(Message.DISPLAY_CALCULATION.getMessage());
            System.out.println(Message.DISPLAY_EXIT.getMessage());
            System.out.print(Message.DISPLAY_CHOOSE.getMessage());
            int choice = Integer.parseInt(br.readLine()); // TODO: 예외처리

            if (choice == 1) {
                // 조회
                System.out.println("조회 기능 미구현");
            } else if (choice == 2) {
                // 계산
                String getInput = br.readLine();
                System.out.println("계산 기능 미구현");
                System.out.println(getInput);
            } else if (choice == 3) {
                // 종료
                System.exit(0);
            } else {
                System.out.println("잘못된 명령입니다!");
            }
        }
    }
}
