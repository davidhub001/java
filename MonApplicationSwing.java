import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonApplicationSwing {

    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Créer la fenêtre principale
            frame = new JFrame("Mon Application Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            // Créer un panneau pour organiser les composants
            JPanel panel = new JPanel();
            frame.add(panel);

            // Utiliser la méthode placeComponents pour ajouter des composants au panneau
            placeComponents(panel);

            // Rendre la fenêtre visible
            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        // Définir un gestionnaire de disposition pour organiser les composants
        panel.setLayout(new BorderLayout());

        // Ajouter une étiquette en haut du panneau
        JLabel label = new JLabel("Entrez votre nom :");
        panel.add(label, BorderLayout.NORTH);

        // Ajouter un champ de texte au centre du panneau
        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.CENTER);

        // Ajouter un bouton en bas du panneau
        JButton button = new JButton("Saluer");
        panel.add(button, BorderLayout.SOUTH);

        // Ajouter une zone de texte avec barre de défilement au centre du panneau
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Ajouter un gestionnaire d'événements au bouton
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtenir le texte du champ de texte
                String nom = textField.getText();

                // Ajouter un message à la zone de texte
                textArea.append("Bienvenue, " + nom + "!\n");

                // Effacer le champ de texte après le salut
                textField.setText("");
            }
        });

        // Ajouter une case à cocher à côté du bouton
        JCheckBox checkBox = new JCheckBox("Option binaire");
        panel.add(checkBox, BorderLayout.EAST);

        // Ajouter un bouton radio à côté de la case à cocher
        JRadioButton radioButton = new JRadioButton("Option exclusive");
        panel.add(radioButton, BorderLayout.EAST);

        // Ajouter une liste déroulante avec des éléments
        String[] elements = {"Élément 1", "Élément 2", "Élément 3"};
        JComboBox<String> comboBox = new JComboBox<>(elements);
        panel.add(comboBox, BorderLayout.EAST);

        // Ajouter une liste avec barre de défilement
        String[] listeElements = {"Élément A", "Élément B", "Élément C"};
        JList<String> list = new JList<>(listeElements);
        panel.add(new JScrollPane(list), BorderLayout.EAST);

        // Ajouter une table avec barre de défilement
        String[][] data = {{"Donnée 1", "Donnée 2"}, {"Donnée 3", "Donnée 4"}};
        String[] columnNames = {"Colonne 1", "Colonne 2"};
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table), BorderLayout.EAST);

        // Ajouter une barre de menus avec un élément de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Fichier");
        JMenuItem menuItem = new JMenuItem("Nouveau");
        menu.add(menuItem);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Ajouter un sélecteur de fichiers
        JFileChooser fileChooser = new JFileChooser();
        panel.add(fileChooser, BorderLayout.EAST);

        // Ajouter une boîte de dialogue d'information
        JOptionPane.showMessageDialog(frame, "Message d'information", "Information", JOptionPane.INFORMATION_MESSAGE);

        // Ajouter une boîte de dialogue de saisie
        String saisie = JOptionPane.showInputDialog(frame, "Entrez quelque chose :", "Saisie", JOptionPane.QUESTION_MESSAGE);
        System.out.println("Vous avez entré : " + saisie);
    }
}
