package main.java.view;

import main.java.domain.Menu;

public interface Input {
    Menu getMenuInput();

    String[] getLineAndParse();
}
