/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.programmers.java;

import com.programmers.java.io.Screen;
import com.programmers.java.repository.RepositoryImpl;

public class App {
    public static void main(String[] args) {
        new Calculator(new Screen(), new RepositoryImpl()).run();
    }
}
