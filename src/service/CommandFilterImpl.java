package service;

public class CommandFilterImpl implements CommandFilter {
    private final ValidationCheck validationCheck;

    public CommandFilterImpl(ValidationCheck validationCheck) {
        this.validationCheck = validationCheck;
    }

    @Override
    public String filter(String command) {
        if (!validationCheck.validate(command))
            throw new RuntimeException("strange command");
        else {
            return command;
        }
    }
}
