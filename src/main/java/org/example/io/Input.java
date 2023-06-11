package org.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static Integer inputMenu() throws IOException {
    return Integer.parseInt(br.readLine());
  }

  public static String inputFormula() throws IOException {
    return br.readLine();
  }
}
