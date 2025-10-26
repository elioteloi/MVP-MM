package clients;

public class CorporateClient extends Client{

    private String cnpj;

    public CorporateClient(int id, String name, String cellphone, Category category, String cnpj) {
        super(id, name, cellphone, category);
        if (name == null || cellphone == null || category == null || cnpj == null) {
            throw new RuntimeException("incomplete data");
        }
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
