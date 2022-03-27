import java.util.List;

public interface IHistory {
    void save(String operation, Number number);
    List<String> getList();
}
