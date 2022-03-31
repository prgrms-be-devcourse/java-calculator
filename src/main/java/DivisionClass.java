public class DivisionClass extends Operator {
    public DivisionClass(){
        super('/');
    }

    @Override
    public float getResult(float a, float b) {
        return a/b;
    }
}
