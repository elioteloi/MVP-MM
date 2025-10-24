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
            throw new RuntimeException("ID do cliente jah existe no cadastro");
        }
        this.products.put(product.getId(), product);
    }

    public Product getProduct(int id) {
        return this.products.get(id);
    }


    public Product editProduct(int id, String name, String barCode, double price, double averageCost, int stock) {
        this.products.get(id).setName(name);
        this.products.get(id).setBarCode(barCode);
        this.products.get(id).setPrice(price);
        this.products.get(id).setAverageCost(averageCost);
        this.products.get(id).setStock(stock);


        return this.products.get(id);
    }

    public void listProduct() {
        for (Product product : products.values()) {
            System.out.println(product);
        }

    }


}
