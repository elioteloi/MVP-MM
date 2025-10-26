package products;
import clients.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {

    private final Map<Integer, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (this.products.containsKey(product.getId())) {
            throw new RuntimeException("ID of the product already exist");
        }
        this.products.put(product.getId(), product);
    }

    public Product getProduct(int id) {
        Product p = this.products.get(id);

        if (p == null) {
            throw new RuntimeException("Product doesn't exist");
        }
        return p;
    }


    public Product editProduct(int id, String name, String barCode, double price, double averageCost, int stock) {
        Product p = this.products.get(id);

        if (p == null) {
            throw new RuntimeException("Product doesn't exist");
        }
        if (name == null || barCode == null) {
            throw new RuntimeException("incomplete data");
        }

        if (price < 0 || averageCost < 0 || stock < 0){
            throw new RuntimeException("data cannot be negative");

        }

        p.setName(name);
        p.setBarCode(barCode);
        p.setPrice(price);
        p.setAverageCost(averageCost);
        p.setStock(stock);


        return p;
    }

    public void listProduct() {
        for (Product product : products.values()) {
            System.out.println(product);
        }

    }


}
