package clients;

import db.DBConnection;

import java.sql.*;

import java.util.HashMap;
import java.util.Map;

public class ClientService {
    private final Map<Integer, Client> client;

    private Connection conn;


    public ClientService() {
        this.client = new HashMap<>();
    }

    public String addClient(Client client) {
        conn = DBConnection.getConnection();

        String selectSQL = "SELECT name FROM userMM WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectSQL)) {
            stmt.setString(1, client.getName());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("there is already a user");
            } else {
                String insertSQL = "INSERT INTO userMM (name, cellphone, category, cpf, cnpj) VALUES (?, ?, ?, ?, ?);";
                try (PreparedStatement stmtIN = conn.prepareStatement(insertSQL);) {
                    stmtIN.setString(1, client.getName());
                    stmtIN.setString(2, client.getCellphone());
                    stmtIN.setString(3, client.getCategory().toString());

                    String cpf = null;
                    String cnpj = null;

                    if (client instanceof IndividualClient) {
                        cpf = ((IndividualClient) client).getCpf();
                    }

                    if (client instanceof CorporateClient) {
                        cnpj = ((CorporateClient) client).getCnpj();
                    }

                    stmtIN.setString(4, cpf);
                    stmtIN.setString(5, cnpj);

                    stmtIN.execute();
                    System.out.println("User successfully created");

                } catch (SQLException e) {
                    System.err.println("Coundn't insert in database: " + e.getMessage());
                }

                return "{}";

            }
        } catch (SQLException e) {
            System.err.println("Coundn't select in database: " + e.getMessage());
        }

        return "{}";

    }


    public String getClient(int id) {
        conn = DBConnection.getConnection();

        String insertSQL = "select * from userMM where id = ?;";

        try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return String.format(
                            "{\"id\": %d, \"name\": \"%s\", \"cellphone\": \"%s\" \"category\": \"%s\" \"cpf\": \"%s\" \"cnpj\": \"%s\"}",
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)
                    );
                }
            System.out.println("User " + id + " successfully selected");

        } catch (SQLException e) {
            System.err.println("Coundn't select client in database: " + e.getMessage());

        }
        return "{}";
    }

    public String editClient(int id, String name, String cellphone, Category category) {
        conn = DBConnection.getConnection();

        if (name == null || cellphone == null || category == null) {
            throw new RuntimeException("incomplete data");
        }


        String insertSQL = "UPDATE userMM SET name = ?, cellphone = ?, category = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
            stmt.setString(1, name);
            stmt.setString(2, cellphone);
            stmt.setString(3, category.toString());
            stmt.setInt(4, id);

            stmt.executeUpdate();
            System.out.println("User " + id + " successfully edited");

        } catch (SQLException e) {
            System.err.println("Coundn't edit client in database: " + e.getMessage());

        }
        return "{}";


    }

    public String listClients () {
        String insertSQL = "select * from userMM";

        try (PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println( String.format(
                        "{\"id\": %d, \"name\": \"%s\", \"cellphone\": \"%s\" \"category\": \"%s\" \"cpf\": \"%s\" \"cnpj\": \"%s\"}",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));

            }

            System.out.println("All users successfully selected");

        } catch (SQLException e) {
            System.err.println("Coundn't select all the clients in database: " + e.getMessage());

        }
        return "{}";
    }
}
