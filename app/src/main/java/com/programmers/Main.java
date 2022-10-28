package com.programmers;

import com.programmers.calculator.Calculator;
import com.programmers.io.Console;
import com.programmers.io.Input;
import com.programmers.io.Output;
import com.programmers.memory.Memory;
import com.programmers.verification.Verification;

public class Main {

  public static void main(String[] args) {
    Input input = new Console();
    Output output = new Console();
    Calculator calculator = new Calculator();
    Memory memory = new Memory();
    Verification verification = new Verification();

    String choice, calcForm;
    Double answer;

    while (true) {
      choice = input.getChoice("1.계산 \n2.조회 \n3.나가기");
      switch (choice) {
        case "1":
          calcForm = input.getForm("계산할 식을 입력해주세요");
          if (verification.verify(calcForm)) {
            answer = memory.contains(calcForm) ? memory.cacheFind(calcForm)
                : calculator.getAnswer(calcForm);

            memory.save(calcForm + " = " + answer);
            memory.cacheSave(calcForm, answer);

            output.printAnswer(answer.toString());
          } else {
            output.printAnswer("제대로 된 계산식이 아닙니다.");
          }

          break;
        case "2":
          output.printMemory(memory.findAll());
          break;
        case "3":
          return;
      }
    }

  }

}