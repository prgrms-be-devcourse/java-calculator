package arithmetic;

public abstract class Operator {
    private char operator;

    public Operator(char operator){
        this.operator = operator;
    }

    public abstract float getResult(float a, float b);
}
