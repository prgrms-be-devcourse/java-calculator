import model.Calculator;
import model.History;



public class Main {

    public static void main(String[] args) {
        new App(new Console(),new History(),new Calculator()).run();
    }

}
