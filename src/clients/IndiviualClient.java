package clients;

public class IndiviualClient extends Client{
    private String cpf;

    public IndiviualClient(int id, String name, String cellphone, Category categoria, String cpf) {
        super(id, name, cellphone, categoria);
    }
}
