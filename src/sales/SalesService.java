package sales;

import products.Product;
import products.ProductService;

import java.util.HashMap;
import java.util.Map;

public class SalesService {
    public final Map<Integer, Sale> sales;
    private final ProductService productService;

    public SalesService(ProductService productService) {
        this.sales = new HashMap<>();
        this.productService = productService;
    }

    double temp = 0;
    public void addSale(Sale sale) {
        if (this.sales.containsKey(sale.getId())) {
            throw new RuntimeException("ID of the sale already exist");
        }
        this.sales.put(sale.getId(), sale);

        for (SalesItems item : sale.salesItems) {
            Product product = productService.getProduct(item.getId());


            // substract the quantity with the stock
            int totalStockAfterSell = product.getStock() - item.getQuantity();
            // edit the new product with the new stock
            productService.editProduct(product.getId(),product.getName(), product.getBarCode(), product.getPrice(), product.getAverageCost(), totalStockAfterSell);
            temp = temp + item.getPrice();
        }
        System.out.println("Total price: " + temp);



        double discountAmount = temp * sale.getDiscount();
        double finalPrice = temp - discountAmount;

        System.out.println("Discount: " + (sale.getDiscount() * 100) + "%");
        System.out.println("Final price: $" + finalPrice);

    }

    public void getAllSalesItems() {
        for (Sale sale : sales.values()) {
            System.out.println(sale);
        }
    }

}
