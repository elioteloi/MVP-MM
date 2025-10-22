package clients;

public class CorporateClient extends Client{

    private String cnpj;

    public CorporateClient(int id, String name, String cellphone, Category categoria, String cnpj) {
        super(id, name, cellphone, categoria);

        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "CorporateClient{" +
                ", parent=" + super.toString() +
                "cnpj='" + this.cnpj + '\'' +
                '}';
    }
}
