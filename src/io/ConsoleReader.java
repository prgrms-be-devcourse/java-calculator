package src.io;

import src.exception.ErrorMessage;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleReader implements Input{
    private final Scanner sc;

    // 테스트를 위해 입력 스트림을 생정자 주입 받는 코드가 클래스에 추가되었음
    // 생성자 주입을 통해 mockInputStream을 사용하는 scanner 주입 받아 테스트를 수행
   public ConsoleReader(InputStream is) {
        sc = new Scanner(is);
    }

    @Override
    public int getChoice() {
        String input = sc.nextLine();
        System.out.println();
        int choice = 0;

        try{
            choice = Integer.parseInt(input);
        }catch (Exception e){
            throw new RuntimeException(ErrorMessage.INVALID_CHOICE.getMessage());
        }
        return choice;
    }

    @Override
    public String getNextLine() {
        return sc.nextLine();
    }
}
