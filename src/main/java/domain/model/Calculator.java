package domain.model;

public class Calculator {

    String operation;

    String answer;

    public Calculator(String operation,
                      String answer) {

        this.operation = operation;
        this.answer = answer;
    }

    public String getOperation() {

        return operation;
    }

    public String getAnswer() {

        return answer;
    }
}
