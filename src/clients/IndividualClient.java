    package clients;

    import java.sql.PreparedStatement;
    import java.sql.SQLException;

    public class IndividualClient extends Client{
        private String cpf;

        public IndividualClient(int id, String name, String cellphone, Category category, String cpf) {
            super(id, name, cellphone, category);

            if (name == null || cellphone == null || category == null) {
                throw new RuntimeException("incomplete data");
            }
            this.cpf = cpf;
        }
        public IndividualClient(int id, String name, String cellphone, Category category) {
            this(id, name, cellphone, category, null);
        }

        public String getCpf() {
            return cpf;
        }

        @Override
        public String toString() {
            return "IndividualClient{" +
                    "parent=" + super.toString() +
                    ", cpf='" + cpf + '\'' +
                    '}';
        }

    }
