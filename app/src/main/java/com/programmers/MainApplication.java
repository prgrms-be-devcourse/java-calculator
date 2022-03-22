package com.programmers;

import com.programmers.service.MainService;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        MainService mainService = new MainService();
        mainService.playCalculate();
    }
}
