package org.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public Integer inputMenu() throws IOException {
    return Integer.parseInt(br.readLine());
  }

  public String inputFormula() throws IOException {
    return br.readLine();
  }
}