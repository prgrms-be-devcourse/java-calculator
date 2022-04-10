package com.calculator.java.engine.comand.inquiry;

import com.calculator.java.database.Database;
import com.calculator.java.engine.comand.Commandable;

import java.util.List;

public class Inquiry implements Commandable {
    private final Database database;

    public Inquiry(Database database) {
        this.database = database;
    }

    @Override
    public String doCommand() {
        List<String> records = database.get();
        return String.join("\n", records);
    }
}
