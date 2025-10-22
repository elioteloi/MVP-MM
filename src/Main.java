import clients.*;
import products.Product;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Client client = new Client(1, "John", "123456789", Category.GOLD);

        CorporateClient corporateClient = new CorporateClient(1, "marc", "48980080", Category.SILVER, "32432434");

        System.out.println(corporateClient);

        IndiviualClient indiviualClient = new IndiviualClient(2, "john", "3243254253", Category.BRONZE, "32243322332");

        System.out.println(indiviualClient);

        ClientService CS = new ClientService();

        CS.addClient(corporateClient);
        CS.addClient(indiviualClient);

        System.out.println(CS.getClient(1));

    }
}