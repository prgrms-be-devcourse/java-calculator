package Domain.Execution;

import Domain.Expression.ExpressionRepository;

public class Inquiry implements Execution {
    @Override
    public boolean execute() {
        ExpressionRepository repository = new ExpressionRepository();
        repository.printAll();
        return true;
    }
}
