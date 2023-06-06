package org.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input{
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String selectAction() throws IOException {
        return br.readLine();
    }

    @Override
    public String input() throws IOException {
        return br.readLine();
    }
}
