import clients.*;
import products.Product;
import products.ProductService;
import sales.DiscountFidelity;
import sales.Sale;
import sales.SalesItems;
import sales.SalesService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // instanciate clients
        CorporateClient corporateClient = new CorporateClient(1, "marc", "48980080", Category.SILVER, "32432434");

        IndiviualClient indiviualClient = new IndiviualClient(2, "john", "3243254253", Category.BRONZE, "32243322332");

        ClientService clientService = new ClientService();

        clientService.addClient(corporateClient);
        clientService.addClient(indiviualClient);

        // get a client
//        System.out.println(clientService.getClient(1));

        // edit the client
//        System.out.println(clientService.editClient(1, "Alice", "999999", Category.GOLD));

        // get one client
//        System.out.println(clientService.getClient(1));

        // list all the clients
//        clientService.listClient();

// ------------------------------------------------------------------------------------------------------------//
        // instanciate products
        ProductService productService = new ProductService();
        Product product1 = new Product(1,"apple", "2323231", 20.00, 10.00, 10);

        Product product2 = new Product(2,"banana", "787863", 10.00, 5.00, 20);

        productService.addProduct(product1);
        productService.addProduct(product2);

        // edit product
//         System.out.println(productService.editProduct(2, "orange", "333", 2.00, 1.50, 50));

        //list all products
//         productService.listProduct();


// ------------------------------------------------------------------------------------------------------------//

        // create discount
        DiscountFidelity discountFidelity = new DiscountFidelity(Category.BRONZE, 10);


        // create new item for sale
        SalesItems salesItems1 = new SalesItems(1, "apple", 10, 20.00);
        SalesItems salesItems2 = new SalesItems(2, "banana", 1, 10.00);


        // create an array to put the items
        SalesItems[] itemsArray1 = new SalesItems[] { salesItems1, salesItems2 };

        // create the sale
        Sale sale1 = new Sale(1, corporateClient, itemsArray1, discountFidelity.discount(Category.BRONZE), 20);


        // put product service to sale service
        SalesService salesService = new SalesService(productService);

        // add new sale
        System.out.println(salesService.addSale(sale1));

        // get all sales items
//        salesService.getAllSalesItems();


    }



}