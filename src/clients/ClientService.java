package clients;

import products.Product;

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
            throw new RuntimeException("ID of the client already exist");
        }
        this.client.put(client.getId(), client);
    }


    public Client getClient(int id) {

        Client c = this.client.get(id);
        if (c == null) {
            throw new RuntimeException("Client doesn't exist");
        }
        return this.client.get(id);
    }

    public Client editClient(int id, String name, String cellphone, Category category) {
        Client c = this.client.get(id);

        if (c == null) {
            throw new RuntimeException("Client doesn't exist");
        }
        if (name == null || cellphone == null || category == null) {
            throw new RuntimeException("incomplete data");
        }

        c.setName(name);
        c.setCellphone(cellphone);
        c.setCategory(category);

        return  c;
    }

    public void listClient () {
        for (Client client : client.values()) {
            System.out.println(client);
        }
    }
}
