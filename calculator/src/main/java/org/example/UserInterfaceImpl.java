package org.example;

import java.util.List;

public class UserInterfaceImpl implements UserInterface{

    ExpressionRepository repository = new ExpressionRepository();
    @Override
    public void showRecord() {
        List<String> record = repository.getRecord();
        record.forEach(System.out::println);
    }
}
