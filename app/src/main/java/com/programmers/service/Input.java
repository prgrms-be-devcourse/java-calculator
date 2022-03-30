package com.programmers.service;

import java.util.Scanner;

public class Input {

    private ValidationService validationCase = new ValidationService();
    Scanner sc = new Scanner(System.in);

    // option 숫자를 입력 받는다.
    int getOptionNumber(){

        int number;

        try {
            number = sc.nextInt();
            sc.nextLine();
            if (!validationCase.validationNumber(number)) {
                throw new IllegalArgumentException("Not valid int input");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Not valid int input");
        }
        return number;
    }

    String getString(){

        String input = sc.nextLine();

        if (!validationCase.validationInput(input)) {
            throw new IllegalArgumentException("Not valid string input");
        }
        return input;
    }

}
