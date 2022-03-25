package com.programmers.java;

import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args){
        Calculator c = new Calculator();
        System.out.println("3 + 2 + 1 * 2");
        System.out.println(c.PostFixForm(new StringTokenizer("3 + 2 + 1 * 2")));
        System.out.println(c.Calc(c.PostFixForm(new StringTokenizer("3 + 2 + 1 * 2"))));
    }
}
