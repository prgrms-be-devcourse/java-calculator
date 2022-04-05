package engine.io;

public interface OutputConsole {

    void output(String s);

    void formula(String formula);

    void inputErrorMessage();

    void illegalArgumentErrorMessage();

    void arithmeticErrorMessage();
}
