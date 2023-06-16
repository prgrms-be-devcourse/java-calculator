import model.Calculator;
import model.HistoryEntity;



public class Main {

    public static void main(String[] args) {
        new App(new Console(),new HistoryEntity(),new Calculator()).run();
    }

}
