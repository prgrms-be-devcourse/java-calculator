import io.Console;
import repository.MapRepository;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        Console console = new Console(new MapRepository());
        console.run();
    }
}
