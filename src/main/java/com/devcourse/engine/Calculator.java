package com.devcourse.engine;

import com.devcourse.engine.io.Input;
import com.devcourse.engine.io.Output;
import com.devcourse.engine.model.Menu;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {

    private Input input;
    private Output output;

    @Override
    public void run() {
        while (true) {
            String menu = input.menuInput();

            if (menu.equals(Menu.EXIT.getMenuOrdinal())) {
                output.endGame();
                break;
            } else if (menu.equals(Menu.HISTORY.getMenuOrdinal())) {

            } else {

            }

        }
    }
}
