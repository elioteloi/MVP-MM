package clients;

public class CorporateClient extends Client{
    private String cnpj;

    public CorporateClient(int id, String name, String cellphone, Category categoria, String cnpj) {
        super(id, name, cellphone, categoria);
    }
}
