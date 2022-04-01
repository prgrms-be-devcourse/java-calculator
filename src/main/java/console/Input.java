package console;

import java.util.Scanner;

public class Input {
    Scanner scanner;
    Output output;

    public Input(Output output){
        scanner = new Scanner(System.in);
        this.output = output;
    }

    public void menuInput(){
        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                output.saveOutput();
                break;
            case 2:
                calculateInput();
                break;
        }

    }

    public void calculateInput(){
        scanner.nextLine();

        String string = scanner.nextLine();

        output.calculateOutput(string);
    }
}
