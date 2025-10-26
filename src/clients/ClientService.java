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
        return this.client.get(id);
    }

    public Client editClient(int id, String name, String cellphone, Category category) {
        this.client.get(id).setName(name);
        this.client.get(id).setCellphone(cellphone);
        this.client.get(id).setCategory(category);

        return  this.client.get(id);
    }

    public void listClient () {
        for (Client client : client.values()) {
            System.out.println(client);
        }
    }
}
