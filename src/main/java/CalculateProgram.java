package main.java;

import main.java.controller.Controller;
import main.java.repository.MapHistoryRepository;
import main.java.service.Calculator;
import main.java.view.ConsoleInput;
import main.java.view.ConsoleOutput;

public class CalculateProgram {

    public static void main(String[] args) {
        new Controller(new ConsoleInput(), new ConsoleOutput(), new Calculator(), new MapHistoryRepository()).run();
    }

}
