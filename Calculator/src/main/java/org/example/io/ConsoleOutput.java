package org.example.io;

import org.example.repository.Repository;

public class ConsoleOutput implements Output{
    @Override
    public void printMenu(String menu) {
        System.out.println(menu);
        System.out.println();
    }
    @Override
    public void printCalculatedResult(int result) {
        System.out.println(result);
        System.out.println();
    }

    @Override
    public void printSavedResults(Repository repository) {
        repository.showSavedResults();
    }
}
