package calculation.io;

import calculation.model.CalcData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BufferedIO implements Input, Output {

  private final BufferedReader br;
  private final BufferedWriter bw;

  public BufferedIO(BufferedReader br, BufferedWriter bw) {
    this.br = br;
    this.bw = bw;
  }

  @Override
  public void printErrorMsg(String errorMsg) throws IOException {
    bw.write("[Error] " + errorMsg + "\n");
    bw.flush();
  }

  @Override
  public int inputCommandType(String prompt) throws IOException {
    bw.write(prompt);
    bw.flush();
    return Integer.parseInt(br.readLine());
  }

  @Override
  public String input() throws IOException {
    return br.readLine().trim();
  }

  @Override
  public void printCommand() throws IOException {
    bw.write("1. 조회\n");
    bw.write("2. 계산\n");
    bw.flush();
  }

  @Override
  public void printAnswer(CalcData calcData) throws IOException {
    bw.write(calcData.getExpression() + " = " + calcData.getAnswer() + "\n");
    bw.flush();
  }
}
