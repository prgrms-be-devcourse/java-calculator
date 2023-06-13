import model.Calculator;
import model.History;



public class Main {

    public static void main(String[] args) {
        new Index(new Console(),new History(),new Calculator()).run();
    }



}
