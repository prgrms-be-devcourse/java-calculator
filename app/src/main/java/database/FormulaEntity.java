package database;

public class FormulaEntity {
    static long nextId = 0;
    private long id;
    private String formula;
    private double result;
    FormulaEntity(String formula, double result){
        this.id = this.nextId++;
        this.formula = formula;
        this.result = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id);
        sb.append(": ");
        sb.append(this.formula);
        sb.append(" = ");
        sb.append(this.result);
        sb.append("\n");
        return sb.toString();
    }
}
