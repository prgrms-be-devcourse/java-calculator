package org.programmers.calculator;

import org.programmers.calculator.configuration.ObjectContainer;
import org.programmers.calculator.configuration.Operand;

public class Main {

    public static void main(String[] args) {
        init();
        Menu menu = ObjectContainer.getMenu();
        menu.run();
    }

    private static void init() {
        ObjectContainer objectContainer = new ObjectContainer();
        objectContainer.create(Operand.RATIONAL_NUMBER);
    }
}
