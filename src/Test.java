import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        // Chargement du pilote JDBC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Informations de connexion à MySQL
        String database = "testjava";
        String url = "jdbc:mysql://localhost:3306/"+database;
        String utilisateur = "david";
        String motDePasse = "david123+";

        // Création de la fenêtre
        JFrame fenetre = new JFrame("Ajouter votre nom");

        // Création du panneau
        JPanel panneau = new JPanel();

        // Création des composants
        JLabel etiquette = new JLabel("Entrez votre nom :");
        JTextField champTexte = new JTextField(10);
        JButton bouton = new JButton("OK");
        JLabel result = new JLabel();

        // Ajout des composants au panneau
        panneau.add(etiquette);
        panneau.add(champTexte);
        panneau.add(bouton);
        panneau.add(result);

        // Ajout d'un écouteur d'événements au bouton
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texteSaisi = champTexte.getText();
                result.setText("Bonjour " + texteSaisi);

                // Connexion à la base de données
                try (Connection connection = DriverManager.getConnection(url, utilisateur, motDePasse)) {
                    // Requête SQL pour insérer le nom dans une table (assurez-vous de créer une table appropriée dans votre base de données)
                    // String sql = "INSERT INTO votre_table (nom) VALUES (?)";
                    // try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    //     preparedStatement.setString(1, texteSaisi);
                    //     preparedStatement.executeUpdate();
                    // }
                    System.out.println("test ok mety be");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Ajout du panneau à la fenêtre
        fenetre.getContentPane().add(panneau);

        // Configuration de la fenêtre
        fenetre.setSize(500, 500);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }
}
