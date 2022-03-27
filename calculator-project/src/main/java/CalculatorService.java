public class CalculatorService implements Runnable{
    static final int VIEW_HISTORY = 1, CALCULATE = 2, EXIT = 3;

    private Input input;
    private Output output;

    @Override
    public void run() {

        while(true){
            output.menu();
            int select = input.input("선택 : ");

            switch(select){
                case VIEW_HISTORY:
                    output.history();
                    break;
                case CALCULATE:
                    output.result();
                    break;
                case EXIT:
                    output.exit();
                    return;
                default:
                    output.inputError();
                    break;
            }
        }
    }
}

