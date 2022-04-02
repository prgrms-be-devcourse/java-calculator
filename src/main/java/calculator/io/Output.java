package calculator.io;

public interface Output {
    String initMessage();
    void print(String str);
    void illegalExceptionMessage();
    void exceptionMessage();
    void divisionByZero();
    void exitMessage();
    void selectionError();
}
