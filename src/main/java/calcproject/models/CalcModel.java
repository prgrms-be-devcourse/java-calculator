package calcproject.models;

public class CalcModel {

    public int id;
    public String expression;
    public double r;

    public CalcModel(String expression, double r) {
        this.expression = expression;
        this.r = r;
    }

    @Override
    public String toString(){
        return this.expression + " = " + this.r;
    }

    public void setExpression(String expression){
        this.expression = expression;
    }
}
