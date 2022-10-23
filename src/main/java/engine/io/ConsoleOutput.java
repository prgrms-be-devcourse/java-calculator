package engine.io;

public class ConsoleOutput implements Output{
    @Override
    public void printError(String message) {
        System.out.println(message);
    }
}
