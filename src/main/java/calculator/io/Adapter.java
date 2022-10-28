package calculator.io;

public class Adapter implements Console{
    @Override
    public String input() {
        return null;
    }

    @Override
    public void inputError() {}

    @Override
    public void exit() {}

    @Override
    public void startMenu() {}
}
