package entity;

public class Data {
    private Long id;
    private String calculationFormula;
    private String result;

    private Data(){

    }

    public Data(Long id, String input, String result) {
        this.id = id;
        this.calculationFormula = input;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public String getCalculationFormula() {
        return calculationFormula;
    }

    public String getResult() {
        return result;
    }
}
