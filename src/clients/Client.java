package clients;

public abstract class Client {

    private int id;
    private String name;
    private String cellphone;
    private Category categoria;

    public Client(int id, String name, String cellphone, Category categoria) {
        this.id = id;
        this.name = name;
        this.cellphone = cellphone;
        this.categoria = categoria;
    }

    public Category getCategoria() {
        return categoria;
    }

    public void setCategoria(Category categoria) {
        this.categoria = categoria;
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
                ", categoria=" + categoria +
                '}';
    }
}
