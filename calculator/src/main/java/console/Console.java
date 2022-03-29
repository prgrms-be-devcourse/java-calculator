package console;

import entity.Expression;

import java.io.*;
import java.util.List;

public class Console implements input, output{

    BufferedReader br;
    BufferedWriter bw;

    public Console() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    @Override
    public String input() throws IOException {
        return br.readLine();
    }

    @Override
    public void printPrompt() throws IOException {
        bw.write("0. 종료\n1. 조회\n2. 계산\n\n선택 : ");
        bw.flush();
    }

    @Override
    public void printCmdFormatError() throws IOException {
        bw.write("명령 형식을 따라 주세요!\n\n");
        bw.flush();
    }

    @Override
    public void printCmdTypeError() throws IOException {
        bw.write("그런 명령은 없습니다!\n\n");
        bw.flush();
    }

    @Override
    public void printExpressionError() throws IOException {
        bw.write("올바른 수식을 입력해주세요!\n\n");
        bw.flush();
    }

    @Override
    public void printHistoryEmptyError() throws IOException {
        bw.write("조회할 이력이 없습니다.\n\n");
        bw.flush();
    }


    @Override
    public void printResultNum(double result) throws IOException {
        bw.write(result + "\n\n");
        bw.flush();
    }

    @Override
    public void printAllHistories(List<Expression> histories) throws IOException {
        histories.iterator()
                .forEachRemaining(System.out::println);

        printNewLine();
    }

    @Override
    public void printExitCall() throws IOException {
        bw.write("계산기 앱을 종료 할게요!\n\n");
        bw.flush();
        closeIO();
    }

    @Override
    public void printNewLine() throws IOException {
        bw.write("\n");
        bw.flush();
    }

    private void closeIO() throws IOException {
        bw.close();
        br.close();
    }
}
