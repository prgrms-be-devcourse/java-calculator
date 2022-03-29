import service.ClientService;

import java.io.IOException;

public class ClientApplication {

    public static void main(String[] args) throws IOException {

        new ClientService().run();
        //CreatorManagement.getClientService().run();
    }
}
