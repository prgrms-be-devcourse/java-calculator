public class PlusClass extends Operator{

    public PlusClass(){
        super('+');
    }

    @Override
    public float getResult(float a, float b) {
        return a+b;
    }


}
