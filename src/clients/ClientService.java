package clients;

import java.util.ArrayList;

public class ClientService {
    ArrayList<Client> clients = new ArrayList<String>();

    public void cadstrarCliente(Client client) {
        clients.add(client);
    }
}
