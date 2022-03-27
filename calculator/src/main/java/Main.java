import service.ServiceImpl;
import service.Service;

public class Main {

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        service.run();
    }
}
