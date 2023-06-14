package org.example;

import java.util.List;

public class UserInterfaceImpl implements UserInterface{

    Repository repository = new ExpressionRepository();
    @Override
    public void showRecords(List<String> records) {
        records.forEach(System.out::println);
    }
}
