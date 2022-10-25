package org.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int selectMenu(String s) throws IOException {
        System.out.print(s);
        return Integer.parseInt(br.readLine());
    }

    @Override
    public String input() throws IOException {
        System.out.println();
        return br.readLine();
    }
}
