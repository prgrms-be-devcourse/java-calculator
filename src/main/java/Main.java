public class Main {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        InputReader inputReader = new InputReader();
        viewer.printInfoMessage();
        CommandType commandType = inputReader.readUserCommand();
        System.out.println(commandType.name());
    }
}
