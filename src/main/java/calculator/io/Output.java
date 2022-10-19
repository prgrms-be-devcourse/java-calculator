package calculator.io;

public interface Output {
    String initMessage();
    void print(String str);
    void exitMessage();
    void errorMessage(Exception e);
}
