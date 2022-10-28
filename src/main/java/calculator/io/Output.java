package calculator.io;

public class Output extends Adapter{

    @Override
    public void startMenu() {
        System.out.print(Message.MENU_MESSAGE);
    }

    @Override
    public void inputError() {
        System.out.println(Message.ERROR_MESSAGE);
    }

    @Override
    public void exit() {
        System.out.println(Message.EXIT_MESSAGE);
    }
}
