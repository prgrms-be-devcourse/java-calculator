package domain;

public class CalculationDto {

    private String command;
    private int result;

    public CalculationDto(String command, int result) {
        this.command = command;
        this.result = result;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
