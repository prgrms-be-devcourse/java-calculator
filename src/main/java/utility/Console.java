package utility;

import engine.io.Input;
import engine.io.Output;
import engine.model.Function;
import engine.model.Record;

import java.util.Scanner;

public class Console implements Output, Input {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void printFunction(Function function) {
        function.indexForEach(System.out::println);
        System.out.print(System.lineSeparator());
    }

    @Override
    public void inputFunctionError() {
        System.out.println("올바른 기능을 선택해 주세요.\n");
    }

    @Override
    public void inputExpressionError() {
        System.out.println("올바른 계산식을 입력해 주세요.\n");
    }

    @Override
    public void outputCalculateAnswer(int answer) {
        System.out.println(answer + "\n");
    }

    @Override
    public void printRecord(Record record) {
        record.printRecord();
        System.out.print(System.lineSeparator());
    }

    @Override
    public void printExitMessage() {
        System.out.println("계산기 종료.");
    }

    @Override
    public String inputFunction(String s) {
        System.out.print(s);
        return scanner.nextLine().trim();
    }

    @Override
    public String inputExpression() {
        return scanner.nextLine().trim();
    }
}
