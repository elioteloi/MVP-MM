import clients.*;
import products.Product;
import products.ProductService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Client client = new Client(1, "John", "123456789", Category.GOLD);

        CorporateClient corporateClient = new CorporateClient(1, "marc", "48980080", Category.SILVER, "32432434");

        System.out.println(corporateClient);

        IndiviualClient indiviualClient = new IndiviualClient(2, "john", "3243254253", Category.BRONZE, "32243322332");

        System.out.println(indiviualClient);

        ClientService clientService = new ClientService();

        clientService.addClient(corporateClient);
        clientService.addClient(indiviualClient);

        System.out.println(clientService.getClient(1));

        ProductService productService = new ProductService();
        Product product1 = new Product(1,"apple", "2323231", 20.00, 10.00, 10);

        productService.addProduct(product1);

        Product product2 = new Product(2,"banana", "787863", 10.00, 5.00, 20);

//        System.out.println(productService.getProduct(1));

        productService.addProduct(product2);

//        System.out.println(productService.getProduct(2));

        System.out.println(productService.editProduct(2, "orange", "333", 2.00, 1.50, 50));

        productService.listProduct();
        // edicão produto
        // listagem product
        // registro no estoque

    }
}