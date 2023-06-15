package Domain.Expression;

public interface Repository<T>{
    void push(T data);
    void printAll();
}
