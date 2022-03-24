import creator.CreatorManagement;
import creator.type.ServiceType;
import service.Service;

public class ClientApplication {

    public static void main(String[] args) {
        Service clientService = CreatorManagement.createService(ServiceType.CLIENT);

        clientService.run();
    }
}
