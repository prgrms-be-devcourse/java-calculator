package calculator.io;

public interface Output {
    String runMessage();
    void print(String str);
    String errorMessage();
    void exitMessage();
}
