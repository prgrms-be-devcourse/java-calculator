package com.programmers;

import com.programmers.calculator.Calculator;
import com.programmers.io.Console;
import com.programmers.io.Input;
import com.programmers.io.Output;
import com.programmers.memory.Memory;

public class Main {

  public static void main(String[] args) {
    Input input = new Console();
    Output output = new Console();
    Calculator calculator = new Calculator();
    Memory memory = new Memory();

    while (true) {
      String choice = input.getChoice("1.계산 \n2.조회 \n3.나가기");
      switch (choice) {
        case "1":
          String calcForm = input.getForm("계산할 식을 입력해주세요");
          Double answer = memory.contains(calcForm) ? memory.cacheFind(calcForm)
              : calculator.getAnswer(calcForm);

          memory.save(calcForm + " = " + answer);
          memory.cacheSave(calcForm, answer);

          output.printAnswer(answer);
          break;
        case "2":
          memory.findAll();
          break;
        case "3":
          return;
      }
    }

  }

}