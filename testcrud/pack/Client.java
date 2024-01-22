package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String nom;
    private String prenom;

    // Constructeurs, getters, setters
    public Client() {
        // Constructeur par défaut nécessaire pour JDBC
    }

    public Client(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Classe ClientDAO
    public static class ClientDAO {
        private static final String URL = "jdbc:mysql://localhost/testjava";
        private static final String USER = "david";
        private static final String PASSWORD = "david123+";

        private static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public static void createClient(Client client) {
            try (Connection connection = getConnection()) {
                String sql = "INSERT INTO client (nom, prenom) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, client.getNom());
                    statement.setString(2, client.getPrenom());
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static List<Client> readAllClients() {
            List<Client> clients = new ArrayList<>();
            try (Connection connection = getConnection()) {
                String sql = "SELECT id, nom, prenom FROM client";
                try (PreparedStatement statement = connection.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nom = resultSet.getString("nom");
                        String prenom = resultSet.getString("prenom");
                        Client client = new Client(id, nom, prenom);
                        clients.add(client);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return clients;
        }

        public static void updateClient(Client client) {
            try (Connection connection = getConnection()) {
                String sql = "UPDATE client SET nom=?, prenom=? WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, client.getNom());
                    statement.setString(2, client.getPrenom());
                    statement.setInt(3, client.getId());
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void deleteClient(int clientId) {
            try (Connection connection = getConnection()) {
                String sql = "DELETE FROM client WHERE id=?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, clientId);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
