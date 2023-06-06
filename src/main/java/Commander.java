import Model.Memorizer;

public class Commander {

    // memorizer, calculator : Singleton.
    private static Memorizer memorizer = Memorizer.getInstance();

    private static Calculator calculator = Calculator.getInstance();






    public static void main(String[] args) {
        getMenu();
    }
}
