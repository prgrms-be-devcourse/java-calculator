package hyuk.repository;

import hyuk.entity.Operands;
import hyuk.entity.Operators;
import hyuk.entity.Result;
import java.util.ArrayList;
import java.util.List;

public class MemoryRepository implements Repository {

    private List<String> repository = new ArrayList<>();

    public void store(Operands operands, Operators operators, Result result) {
        repository.add(makeLog(operands, operators, result));
    }

    private String makeLog(Operands operands, Operators operators, Result result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operands.getOperands().size(); ++i) {
            sb.append(operands.getOperands().get(i) + " ");
            if (i < operators.getOperators().size()) {
                sb.append(operators.getOperators().get(i) + " ");
            }
        }
        sb.append("= " + result.showResult());

        return sb.toString();
    }

    public List<String> getData() {
        return repository;
    }
}
