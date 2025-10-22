import clients.Category;
import clients.Client;
import clients.ClientService;
import clients.CorporateClient;
import products.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Client client = new Client(1, "John", "123456789", Category.GOLD);

//        CorporateClient corporateClient new CorporateClient(2, "marc", "48980080", Category.SILVER);
        CorporateClient corporateClient = new CorporateClient(2, "marc", "48980080", Category.SILVER, "32432434");

        System.out.println(corporateClient);


        Product p1 = new Product(1, "Laptop", "ABC123", 1200.0, 1000.0, 6);

        System.out.println(p1);

        ClientService CS = new ClientService();

    }
}