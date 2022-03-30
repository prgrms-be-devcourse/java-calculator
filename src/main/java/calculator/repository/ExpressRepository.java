package calculator.repository;

public interface ExpressRepository {
    void save(String exp, int answer);
    int findByExpress(String exp);

    void clearStore();
}
