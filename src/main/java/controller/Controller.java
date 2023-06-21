package main.java.controller;

import main.java.domain.Command;
import main.java.domain.History;
import main.java.domain.Menu;
import main.java.repository.HistoryRepository;
import main.java.service.Calculator;
import main.java.view.Input;
import main.java.view.Output;

import static main.java.view.ConsoleInput.*;


public class Controller {

    private final Input input;
    private final Output output;
    private final Calculator calculator;
    private final HistoryRepository repository;

    public Controller(Input input, Output output, Calculator calculator, HistoryRepository repository) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
        this.repository = repository;
    }

    public void run() {

        while(true) {
            try {
                output.printMenu(Menu.values());
                // menu 객체로 만듦.
                Menu menu = input.getMenuInput();

                switch (menu.getMenuNum()) {
                    case SHOWMENU:
                        output.showHistory(repository.getAllHistoryToList());
                        break;

                    case CALCULATEMENU:
                        Command command = new Command(input.getLineAndParse());
                        int result = calculator.calculate(command);

                        // output에서 DTO
                        output.printResult(result);
                        History history = new History(command.getCommandArr(), result);
                        repository.saveHistory(history);
                        break;

                    case EXITMENU:
                        output.exitProgram();
                        scannerClose();
                        return;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
