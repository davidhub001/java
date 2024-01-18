import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample {

    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Exemple Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Création d'un panneau pour organiser les composants
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // Utilisation d'un gestionnaire de mise en page FlowLayout
        panel.setLayout(new FlowLayout());

        // Étiquette
        JLabel label = new JLabel("Bienvenue dans l'exemple Swing !");
        panel.add(label);

        // Champ de texte
        JTextField textField = new JTextField("Saisissez quelque chose");
        panel.add(textField);

        // Bouton avec gestionnaire d'événements
        JButton button = new JButton("Cliquez-moi !");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bouton cliqué !");
            }
        });
        panel.add(button);

        // Case à cocher
        JCheckBox checkBox = new JCheckBox("Accepter les termes");
        panel.add(checkBox);

        // Bouton radio
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButton1);
        radioButtonGroup.add(radioButton2);
        panel.add(radioButton1);
        panel.add(radioButton2);

        // Liste déroulante
        String[] options = {"Option A", "Option B", "Option C"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        panel.add(comboBox);

        // Zone de texte déroulante
        JTextArea textArea = new JTextArea("Zone de texte déroulante");
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        // Barre de défilement
        JScrollBar scrollBar = new JScrollBar();
        panel.add(scrollBar);
    }
}
