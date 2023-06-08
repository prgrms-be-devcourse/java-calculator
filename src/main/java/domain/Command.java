package main.java.domain;

import main.java.service.Operator;

public class Command {

    public String[] commandArr;
    public int[] numberArr;
    public Operator[] optArr;
    public int optCount;

    public Command(String[] commandArr) {
        this.commandArr = commandArr;
        this.optCount = commandArr.length / 2;
        this.numberArr = new int[optCount + 1];
        this.optArr = new Operator[optCount];
    }

    public String makeHistory(int result) {
        return String.join(" ", this.commandArr) + " = " + result;
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
