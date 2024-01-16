import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {

    public static void main(String[] args) {
        // Informations de connexion à MySQL
        String database = "testjava";
        String url = "jdbc:mysql://localhost:3306/" + database;
        String utilisateur = "david";
        String motDePasse = "david123+";

        try {
            // Étape 2 : Créer l'objet de connexion
            System.out.println("Connexion à la base de données sélectionnée...");

            try (Connection conn = DriverManager.getConnection(url, utilisateur, motDePasse)) {
                // Étape 3 : Utiliser la connexion
                System.out.println("Base de données connectée avec succès...");
            } // La connexion sera automatiquement fermée à la fin du bloc try
        } catch (SQLException e) {
            // Gestion des exceptions
            e.printStackTrace();
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
}
