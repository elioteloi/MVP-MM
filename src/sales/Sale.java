package sales;

import clients.Client;

import java.time.LocalDateTime;

public class Sale {
    private int id;
    private LocalDateTime dataHora;
    private Client client;

    public Sale(int id, LocalDateTime dataHora, Client client) {
        this.id = id;
        this.dataHora = dataHora;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }




}

