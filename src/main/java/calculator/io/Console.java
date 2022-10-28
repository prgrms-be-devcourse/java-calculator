package calculator.io;

public interface Console {
    void startMenu();
    String input();
    void inputError();
    void exit();
}
