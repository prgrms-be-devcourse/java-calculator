import creator.CreatorManagement;

import java.io.IOException;

public class ClientApplication {

    public static void main(String[] args) throws IOException {

        CreatorManagement
                .getClientService().run();
    }
}
