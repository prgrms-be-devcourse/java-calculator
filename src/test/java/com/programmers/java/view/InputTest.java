package com.programmers.java.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

class InputTest {

    private Input input;

    @BeforeEach
    void setUp() {
        input = new Input();
    }

    @Test
    void enterMenu_Input1() throws IOException {
        String inputString = "1";
        provideInput(inputString);

        Optional<Menu> expectedMenu = Optional.of(Menu.SEARCH);
        Optional<Menu> actualMenu = input.enterMenu();

        Assertions.assertEquals(expectedMenu, actualMenu);
    }
    @Test
    void enterMenu_Input2() throws IOException {
        String inputString = "2";
        provideInput(inputString);

        Optional<Menu> expectedMenu = Optional.of(Menu.CALCULATE);
        Optional<Menu> actualMenu = input.enterMenu();

        Assertions.assertEquals(expectedMenu, actualMenu);
    }

    @Test
    void enterMenu_InputOther() throws IOException {
        String inputString = "5";
        provideInput(inputString);

        Optional<Menu> actualMenu = input.enterMenu();

        Assertions.assertEquals(Optional.empty(), actualMenu);
    }

    private void provideInput(String inputString) {
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);
    }
}