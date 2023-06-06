import model.History;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Index implements Runnable{
    private Console console;
    private History history;
    Index(Console console, History history){
        this.console = console;
        this.history = history;
    }
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. 조회");
        System.out.println("2. 계산");

        int select = sc.nextInt();

        switch (select){
            case 1:
                console.getHistory();
            case 2:
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String inputString = br.readLine();
                    console.input(inputString);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }

    }

}
