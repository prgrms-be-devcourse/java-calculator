package programmers.calculator;

import lombok.AllArgsConstructor;
import programmers.calculator.controller.ControlUnit;
import programmers.calculator.io.Input;
import programmers.calculator.io.Output;

@AllArgsConstructor
public class Calculator implements Runnable {

  private final Input input;
  private final Output output;
  private final ControlUnit controlUnit;

  @Override
  public void run() {
    while (true) {
      output.printMenu();
      MenuOption option = MenuOption.of(input.read());
      selectMenu(option);
    }
  }

  private void selectMenu(MenuOption option) {
    String result = switch (option) {
      case HISTORY -> controlUnit.printHistory();
      case CALCULATE -> execute(input.read());
      case ERROR -> "잘못된 메뉴를 선택했습니다.";
    };
    output.printLine(result);
  }

  private String execute(String input) {
    try {
      return controlUnit.execute(input);
    } catch(IllegalArgumentException | ArithmeticException e){
      return e.getMessage();
    }
  }

}
