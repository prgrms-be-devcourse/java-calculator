import model.Calculator;
import model.History;
import model.Operator;
import option.Option;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Index implements Runnable{
    private Console console;
    private History history;
    private Calculator calculator;
    private Operator operator;

    public Index(Console console, History history, Calculator calculator, Operator operator) {
        this.console = console;
        this.history = history;
        this.calculator = calculator;
        this.operator = operator;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            for(Option opt : Option.values()){
                System.out.println(opt.getIdx()+". "+opt.getOpt());
            }


            int select = sc.nextInt();

            switch (select) {
                case 1:
                    console.getHistory(history);
                    break;
                case 2:
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String inputString = br.readLine();
                        console.input(inputString,calculator,operator,history);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            }
        }
    }

}
