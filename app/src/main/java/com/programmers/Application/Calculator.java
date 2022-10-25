package com.programmers.Application;


import com.programmers.calculation.Calculation;
import com.programmers.io.Input;
import com.programmers.io.Output;
import com.programmers.repository.Repository;
import com.programmers.verification.VerificationImpl;
import java.util.List;

public class Calculator implements Runnable {

  private final Input input;
  private final Output output;
  private final VerificationImpl verification;
  private final Repository repository;
  private final Calculation calculation;

  public Calculator(Input input, Output output, VerificationImpl verification,
      Repository repository,
      Calculation calculation) {
    this.input = input;
    this.output = output;
    this.verification = verification;
    this.repository = repository;
    this.calculation = calculation;
  }

  @Override
  public void run() {
    while (true) {

      int choice = input.getChoice("1.계산 \n2.조회 \n3.나가기");

      switch (choice) {
        case 1 -> {
          String form = input.prompt("계산식을 입력해주세요. \nex)1 + 2");
          if (verification.verifyInput(calculation.toList(form.split(" ")))) {
            output.printAnswer("올바른 계산식을 입력해주세요");
          } else {
            String answer = getAnswer(form);
            repository.save(form, answer);
            output.printAnswer(answer);
          }
        }
        case 2 -> {
          if (repository.findAll().size() == 0) {
            output.printAnswer("저장된 데이터가 없습니다");
          } else {
            output.printMemory(repository.findAll());
          }
        }

        case 3 -> {
          return;
        }

      }
    }
  }

  public String getAnswer(String form) {
    if (repository.find(form)) {
      return repository.getValue(form);
    }
    List<String> formArray = calculation.toList(form.split(" "));
    return calculation.calculate(formArray);
  }


}
