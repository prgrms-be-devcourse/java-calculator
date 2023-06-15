package calculator;

import function.Calculation;
import function.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static print.Choice.printChoice;
import static validator.Validator.checkChoiceNum;

public class Calculator {
    Calculation calculation;
    Storage storage;

    public Calculator() {
        this.calculation = new Calculation();
        this.storage = new Storage();
    }

    public void run() throws IOException {
        BufferedReader br;

        while (true) {
            printChoice();

            br = new BufferedReader(new InputStreamReader(System.in));
            int choice = checkChoiceNum(Integer.parseInt(br.readLine()));
            System.out.println();

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println(storage.print());
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
                String expression = br.readLine();
                String result = convertByType(calculation.calculatePostfix(calculation.convertPostfix(expression)));

                storage.store(expression + " = " + result);
                System.out.println(result);
                System.out.println();
            }
        }
    }

    private String convertByType(double result) {
        if (result == (int) result) {
            return String.valueOf((int) result);
        }
        return String.valueOf(result);
    }
}
