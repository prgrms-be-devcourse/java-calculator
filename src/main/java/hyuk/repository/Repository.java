package hyuk.repository;

import hyuk.entity.Operands;
import hyuk.entity.Operators;
import hyuk.entity.Result;
import java.util.List;

public interface Repository {

    void store(Operands operands, Operators operators, Result result);

    List<String> getData();
}
