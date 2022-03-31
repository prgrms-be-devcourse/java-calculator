public class PlusClass extends Operator{

    public PlusClass(){
        super('+');
    }

    @Override
    public int getResult(int a, int b) {
        return a+b;
    }


}
