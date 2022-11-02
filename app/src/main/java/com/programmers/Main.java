package com.programmers;

import com.programmers.calculator.Calculator;
import com.programmers.console.Console;
import com.programmers.console.Menu;
import com.programmers.memory.Memory;
import com.programmers.verification.Verification;

public class Main {

  public static void main(String[] args) {
    Console console = new Console();
    Calculator calculator = new Calculator();
    Memory memory = new Memory();
    Verification verification = new Verification();

    while (true) {

      Menu menu = console.getCommand("1.계산 \n2.조회 \n3.나가기");

      switch (menu) {
        case CALC:
          String calcForm = console.getExpression("계산할 식을 입력해주세요");
          if (verification.verify(calcForm)) {
            Double answer = calculator.getAnswer(calcForm);

            memory.save(calcForm + " = " + answer);

            console.print(answer.toString());
          } else {
            console.print("제대로 된 계산식이 아닙니다.");
          }

          break;
        case INQUIRY:
          console.print(memory.findAll());
          break;
        case OUTSIDE:
          return;
        case NORESULT:
          console.print("다시 선택해주세요");
          break;
      }

    }

  }

}