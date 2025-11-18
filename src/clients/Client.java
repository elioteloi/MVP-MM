package clients;

public class Client {

    private int id;
    private String name;
    private String cellphone;
    private Category category;

    public Client(int id, String name, String cellphone, Category category) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("Dados incompletos: nome não pode ser vazio");
        }
        if (cellphone == null || cellphone.isBlank()) {
            throw new RuntimeException("Dados incompletos: telefone não pode ser vazio");
        }

        this.id = id;
        this.name = name;
        this.cellphone = cellphone;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoria) {
        this.category = categoria;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", categoria=" + category +
                '}';
    }
}
