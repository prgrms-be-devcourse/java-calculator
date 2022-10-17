package calculator.repository;

import calculator.io.Output;

public interface ExpressRepository {
    void save(String exp, int answer);
    int findByExpress(String exp);
    void clearStore();

    void historyPrint(Output out);
}
