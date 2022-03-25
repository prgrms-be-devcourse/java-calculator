package model;

public class CalculationDto {

    private String command;
    private Double result;

    public CalculationDto(String command, Double result) {
        this.command = command;
        this.result = result;
    }

    public String toString() {
        return this.command + " = " + result;
    }

}
