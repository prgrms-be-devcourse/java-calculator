package main.java.controller;

import main.java.domain.Command;
import main.java.domain.Menu;
import main.java.exception.OutOfMenuException;
import main.java.exception.WrongCommandException;
import main.java.repository.MapRepository;
import main.java.repository.Repository;
import main.java.service.Calculator;
import main.java.view.ConsoleInput;
import main.java.view.ConsoleOutput;
import main.java.view.Input;
import main.java.view.Output;

import static main.java.view.ConsoleInput.*;


public class Controller {

    private Input input;
    private Output output;
    private Calculator calculator;
    private Repository repository;

    public Controller(Input input, Output output, Calculator calculator, Repository repository) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
        this.repository = repository;
    }

    public void run() {
        Menu menu;
        Command command;
        int result;

        while(true) {
            try {
                output.printMenu();
                // menu 객체로 만듦.
                menu = input.getMenuInput();

                switch (menu.getMenuNum()) {
                    case SHOWMENU:
                        output.showHistory(repository);
                        break;

                    case CALCULATEMENU:
                        command = new Command(input.getLineAndParse());
                        command.parseComamand();
                        result = calculator.calculate(command);
                        output.printResult(result);
                        repository.saveHistory(command.makeHistory(result));
                        break;

                    case EXITMENU:
                        output.exitProgram();
                        return;
                }
            } catch (WrongCommandException e) {
                e.printStackTrace();
            } catch (OutOfMenuException e) {
                e.printStackTrace();
            }

        }
    }

}
