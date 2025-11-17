package sales;

import clients.Client;
import clients.ClientService;
import products.Product;
import products.ProductService;

import java.util.HashMap;
import java.util.Map;

public class SalesService {
    public final Map<Integer, Sale> sales;
    private final ProductService productService;
    private final ClientService clientService;

    public SalesService(ProductService productService, ClientService clientService) {
        this.sales = new HashMap<>();
        this.productService = productService;
        this.clientService = clientService;
    }
//
//    public String addSale(Sale sale) {
//
//
//        Client client = clientService.getClient(sale.getClient().getId());
//        // check if client exist
//         if (client == null) {
//                throw new RuntimeException("Client doesn't exist");
//            }
//
//        double total = 0.0;
//        if (this.sales.containsKey(sale.getId())) {
//            throw new RuntimeException("ID of the sale already exist");
//        }
//        this.sales.put(sale.getId(), sale);
//
//        for (SalesItems item : sale.salesItems) {
//            Product product = productService.getProduct(item.getId());
//
//
//
//            if (product.getStock() < item.getQuantity()) {
//                    throw new RuntimeException("Not enough stock for product: " + product.getName());
//            }
//
//            // subtract the quantity with the stock
//            int totalStockAfterSell = product.getStock() - item.getQuantity();
//            // edit the new product with the new stock
//            productService.editProduct(product.getId(),product.getName(), product.getBarCode(), product.getPrice(), product.getAverageCost(), totalStockAfterSell);
//
//            // give the total of the sale
//            total = total + item.getPrice() * item.getQuantity();
//
//            System.out.println("Item: " + item);
//        }
//
//        double discountAmount = total * sale.getDiscount();
//        double finalPrice = total - discountAmount;
//
//        // put total price to sale class
//        sale.setTotalPrice(finalPrice);
//
//
//
//        return String.format("Total price: $%.2f%nDiscount: %.0f%%%nFinal price: $%.2f",
//                total, sale.getDiscount() * 100, finalPrice);
//    }
//
//    public void getAllSalesItems() {
//        for (Sale sale : sales.values()) {
//            System.out.println(sale);
//        }
//    }

}
