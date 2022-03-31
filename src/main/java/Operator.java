public abstract class Operator {
    private char operator;

    public Operator(char operator){
        this.operator = operator;
    }

    public abstract int getResult(int a, int b);
}
