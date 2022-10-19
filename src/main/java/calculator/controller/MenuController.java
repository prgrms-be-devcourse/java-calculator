package calculator.controller;

import calculator.view.input.BaseInput;
import calculator.view.input.MenuInput;

public class MenuController {

    public void process() {
        menuInput().input();
    }

    private BaseInput menuInput() {
        return new MenuInput();
    }
}
