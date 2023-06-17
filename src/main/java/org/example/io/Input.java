package org.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static Integer inputMenu() {
    try {
      String getMenu = br.readLine();
      return Integer.parseInt(getMenu);
    } catch (IOException e) {
      throw new RuntimeException("보기의 메뉴 중에서 선택하세요.");
    }
  }

  public static String inputFormula() {
    try {
      return br.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
