package main.java.controller;

import main.java.domain.Command;
import main.java.domain.Menu;
import main.java.repository.MapRepository;
import main.java.service.Calculator;
import main.java.view.ConsoleInput;
import main.java.view.ConsoleOutput;

import static main.java.view.ConsoleInput.*;


public class Controller {

    ConsoleInput consoleInput;
    ConsoleOutput consoleOutput;
    Calculator calculator;
    MapRepository mapRepository;

    public Controller(ConsoleInput consoleInput, ConsoleOutput consoleOutput, Calculator calculator, MapRepository mapRepository) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.calculator = calculator;
        this.mapRepository = mapRepository;
    }

    public void run() {
        Menu menu;
        Command command;
        int result;

        while(true) {
            consoleOutput.printMenu();

            // menu 객체로 만듦.
            menu = consoleInput.getMenuInput();
            consoleInput.flushBuffer();
            switch (menu.getMenuNum()) {
                case SHOWMENU:
                    // showHistory input으로 Repository
                    // query 결과 넣어주면 될 듯.
                    consoleOutput.showHistory();
                    break;
                case CALCULATEMENU:
                    command = new Command(consoleInput.getLine());
                    if(!command.isValidCommand()) {
                        consoleOutput.printError();
                        break;
                    }
                    command.parseComamand();
                    result = calculator.calculate(command);
                    System.out.println(result);
                    break;
                case EXITMENU:
                    consoleOutput.exitProgram();
                    break;
                default:
                    consoleOutput.printError();
            }
        }
    }

}
