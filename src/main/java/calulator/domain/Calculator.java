package calulator.domain;

import calulator.input.InputView;

public class Calculator {

    private final InputView inputView = new InputView();

    private final void run() {
        int i = inputView.inputMenu();
        if (i == 2) {

        }
    }

//    private int findPriority(String expression) {
//        for (int i = 0; i < expression.length(); i++) {
//            if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
//
//            }
//        }


}
