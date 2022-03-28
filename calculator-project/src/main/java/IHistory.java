import java.util.List;

public interface IHistory {
    boolean save(String operation, Double number);
    List<String> getList();
    boolean isExist(String operation);
    Double getResult(String operation);
}
