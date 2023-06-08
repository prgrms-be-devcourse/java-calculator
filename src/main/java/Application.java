import view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig ac = new ApplicationConfig();
        CalculatorView view = ac.getView();

        while (true) {
            view.printInit();
        }

    }
}