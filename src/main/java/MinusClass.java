public class MinusClass extends Operator {

    public MinusClass(){
        super('-');
    }

    @Override
    public int getResult(int a, int b) {
        return a-b;
    }

}
