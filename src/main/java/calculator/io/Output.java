package calculator.io;

public interface Output {
    String initMessage();
    void print(String str);
    String errorMessage();
    void exitMessage();
}
