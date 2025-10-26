package sales;

import clients.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Sale {
        private int id;
        private LocalDateTime dataHora;
        private Client client;
        public ArrayList<SalesItems> salesItems = new ArrayList<>();
        private double discount;
        private double totalPrice;

        public Sale(int id, Client client, SalesItems[] salesItemsArray, double discount, double totalPrice) {

            if (client == null || salesItemsArray == null) {
                throw new RuntimeException("incomplete data");
            }

            if (id < 1 || discount < 0 || totalPrice < 0){
                throw new RuntimeException("data cannot be negative");
            }

            this.id = id;
            this.dataHora = LocalDateTime.now();
            this.client = client;
            this.salesItems.addAll(Arrays.asList(salesItemsArray));
            this.discount = discount;
            this.totalPrice = totalPrice;
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

    public void setSalesItems(SalesItems[] salesItemsArray) {
        this.salesItems.addAll(Arrays.asList(salesItemsArray));
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", dataHora=" + dataHora +
                ", client=" + client +
                ", salesItems=" + salesItems +
                ", discount=" + discount +
                ", TotalPrice=" + totalPrice +
                '}';
    }
}

