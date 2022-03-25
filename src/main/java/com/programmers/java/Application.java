package com.programmers.java;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.PostFixForm(new StringTokenizer("3 + 2 + 4 * 5 + 3 / 1")));
    }
}
