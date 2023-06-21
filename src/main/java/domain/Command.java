package main.java.domain;

import main.java.service.Operator;

public class Command {

    private String[] commandArr;
    private int[] numberArr;
    private Operator[] optArr;
    private int optCount;

    public Command(String[] commandArr) {
        this.commandArr = commandArr;
        this.optCount = commandArr.length / 2;
        this.numberArr = new int[optCount + 1];
        this.optArr = new Operator[optCount];

        parseComamand();
    }

    public String[] getCommandArr() {
        return commandArr;
    }

    public int[] getNumberArr() {
        return numberArr;
    }

    public Operator[] getOptArr() {
        return optArr;
    }

    public int getOptCount() {
        return optCount;
    }

    public void parseComamand() {
        for(int i = 0; i < commandArr.length; i++) {
            if(i % 2 == 0) {
                numberArr[i / 2] = Integer.parseInt(commandArr[i]);
                continue;
            }
            optArr[i / 2] = Operator.stringToOperator(commandArr[i]);
        }
    }

}
