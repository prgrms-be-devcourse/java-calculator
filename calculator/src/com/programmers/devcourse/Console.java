package com.programmers.devcourse;

import com.programmers.devcourse.io.Input;
import com.programmers.devcourse.io.Output;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Console implements Input, Output, AutoCloseable {

  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private final String MENU = "1. 조회\n2. 계산\n3. 종료";

  @Override
  public int getMenuSelection() throws IOException {
    System.out.println(MENU);
    System.out.print("선택 : ");
    int mode = 999;
    try {

      mode = Integer.parseInt(br.readLine());
    } catch (NumberFormatException ignored) {
    }
    System.out.println();
    return mode;
  }

  @Override
  public String getExpression() throws IOException {
    return br.readLine();
  }


  @Override
  public void close() throws IOException {
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
