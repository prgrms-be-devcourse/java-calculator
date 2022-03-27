package consoleview;

public class ConsoleView {
    private final String mainMessage = "1. 조회\n2. 계산\n\n선택 : ";
    public void display() {
        this.display(mainMessage);
    }
    public void display(String message) {
        System.out.println(message);
    }
}
