package clients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientService {
    private final Map<Integer, Client> client;

    public ClientService() {
        this.client = new HashMap<>();
    }

    public void addClient(Client client) {
        if (this.client.containsKey(client.getId())) {
            throw new RuntimeException("ID do cliente jah existe no cadastro");
        }
        this.client.put(client.getId(), client);
    }


    public Client getClient(int id) {
        return this.client.get(id);
    }
}
