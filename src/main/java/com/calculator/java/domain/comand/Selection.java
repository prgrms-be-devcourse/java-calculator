package com.calculator.java.domain.comand;

import com.calculator.java.domain.database.Database;

import java.util.List;

public class Selection implements Command {
    private Database database;

    public Selection(Database database) {
        this.database = database;
    }

    @Override
    public String doCommand() {
        List<String> records = database.get();
        String result = String.join("\n", records);

        return result;
    }
}
