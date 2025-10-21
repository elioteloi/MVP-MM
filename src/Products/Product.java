package Products;

public class Product {

    private int id;
    private String name;
    private String barCode;

    public Product(int id, String name, String barCode, double price, double averageCost, int stock) {
        this.id = id;
        this.name = name;
        this.barCode = barCode;
        this.price = price;
        this.averageCost = averageCost;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAverageCost() {
        return averageCost;
    }

    public void setAverageCost(double averageCost) {
        this.averageCost = averageCost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private double price;
    private double averageCost;
    private int stock;




}
