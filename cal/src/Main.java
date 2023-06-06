import model.History;

public class Main {
    public static void main(String[] args) {

        Console console = new Console();
        History history = new History();
        new Index(console,history).run();
    }
}
