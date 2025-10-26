package clients;

public class IndiviualClient extends Client{
    private String cpf;

    public IndiviualClient(int id, String name, String cellphone, Category category, String cpf) {
        super(id, name, cellphone, category);

        if (name == null || cellphone == null || category == null || cpf == null) {
            throw new RuntimeException("incomplete data");
        }
        this.cpf = cpf;
    }
}
