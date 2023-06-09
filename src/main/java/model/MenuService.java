package model;

import exception.CalculatorException;
import model.menu.SelectMenuExecutor;

import view.OutputView.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MenuService {
    private final List<SelectMenuExecutor> executors;

    public MenuService(final SelectMenuExecutor ...executors) {
        this.executors = new ArrayList<>(Arrays.asList(executors));
    }

    public void menuService(final Menu userSelectMenu) throws CalculatorException {
        int userSelectMenuNumber = userSelectMenu.getMenuNumber();
        for(SelectMenuExecutor executor : executors) {
            if (executor.isNumberSatisfiedBy(userSelectMenuNumber)) {
                executor.execute();
            }
        }
    }
}
