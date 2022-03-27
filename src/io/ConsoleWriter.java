package src.io;

import src.log.Log;

import java.util.List;

public class ConsoleWriter implements Output{

    @Override
    public void printPrompt() {
        System.out.println("1. 조회\n" +
                           "2. 계산\n");
        System.out.print("선택 : ");

    }

    @Override
    public void printError(String message) {
        System.out.println(message+"\n");

    }

    @Override
    public void printLog(List<Log> logs) {
        for (Log log : logs) System.out.println(log);
        System.out.println();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer+"\n");
    }
}
