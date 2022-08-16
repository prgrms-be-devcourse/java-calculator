package arithmetic;

public class MinusClass extends Operator {

    public MinusClass(){
        super('-');
    }

    @Override
    public float getResult(float a, float b) {
        return a-b;
    }

}
