package main.java.domain;

import main.java.service.Operator;

import java.util.Arrays;

public class Command {

    public String[] commandArr;
    public int[] numberArr;
    public Operator[] optArr;
    public String calculateResult;
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

    public boolean isValidCommand() {
        if((isValidNumber() && isValidOperator()) == true)
            return true;
        return false;
    }

    private boolean isStringDigit(String Number) {
        for (int i = 0; i < Number.length(); i++) {
            if (!Character.isDigit(Number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidNumber() {
        for(int i = 0; i < this.commandArr.length; i += 2)
            if(!isStringDigit(this.commandArr[i]))
                return false;
        return true;
    }

    private boolean isValidOperator() {
        for(int i = 1; i < this.commandArr.length; i += 2) {
            if(!Operator.isValidOperator(this.commandArr[i]))
                return false;
        }
        return true;
    }
}
