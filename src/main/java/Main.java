public class Main {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        InputReader inputReader = new InputReader();
        Calculator calculator = new Calculator();

        while (true) {
            viewer.printInfoMessage();
            CommandType command = inputReader.readUserCommand();
            viewer.printNewLine();
            if (command.equals(CommandType.HISTORY_COMMAND)) {
                System.out.println("아직 구현 안함");
            }
            if (command.equals(CommandType.CALCULATE_COMMAND)) {
                String expression = inputReader.readExpression();
                int answer = calculator.calculate(expression);
                viewer.printAnswer(answer);
            }
        }
    }
}
