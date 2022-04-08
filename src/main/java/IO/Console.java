package IO;

import Record.*;
import Result.ErrorCode;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMenu() {
        output("1.조회");
        output("2.계산");
        output("3.종료");
    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }

    @Override
    public void errorPrint(ErrorCode errorCode) {
        System.out.println(errorCode.getMessage());
    }

    @Override
    public void allCalcRecord(Map<Long, Record> map) {
        Iterator<Long> keys = map.keySet().iterator();
        while (keys.hasNext()) {
            Long key = keys.next();
            System.out.println(key + " : " + map.get(key).getExpress());
        }
    }

    @Override
    public String input(String s) {
        System.out.println(s);
        return scanner.nextLine();
    }
}
