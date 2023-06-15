package Domain.Execution;

public class None implements Execution {
    @Override
    public boolean execute() {
        return false;
    }
}
