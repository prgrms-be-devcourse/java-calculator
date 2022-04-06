package arithmetic;

public class MultipleClass extends Operator {
    public MultipleClass(){
        super('*');
    }

    @Override
    public float getResult(float a, float b) {
        return a*b;
    }
}
