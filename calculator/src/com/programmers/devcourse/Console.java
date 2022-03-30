package com.programmers.devcourse;

import com.programmers.devcourse.io.Input;
import com.programmers.devcourse.io.Output;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Console implements Input, Output {

  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  @Override
  public int getMenuSelection() throws IOException {
    System.out.println("1. 조회");
    System.out.println("2. 계산\n");
    System.out.print("선택 : ");
    int mode = Integer.parseInt(br.readLine());
    System.out.println();
    return mode;
  }

  @Override
  public String getExpression() throws IOException {
    return br.readLine();
  }

  @Override
  public void close() throws IOException {
    System.out.println("계산기 종료");
    br.close();
  }

  @Override
  public void sendMessage(String s) {
    System.out.println(s);
  }

  @Override
  public void sendAllResults(Map<?, ? extends Number> map) {

    if (map.size() == 0) {
      System.out.println("없음\n");
      return;
    }

    map.forEach((key, value) -> {
      System.out.println(key + " = " + value);
    });

    System.out.println();
  }

}
