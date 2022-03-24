package com.calculator.java.comand;

import com.calculator.java.database.Database;

import java.util.List;

public class Selection implements Command {
    private final Database database;

    public Selection(Database database) {
        this.database = database;
    }

    @Override
    public String doCommand() {
        List<String> records = database.get();
        return String.join("\n", records);
    }
}
