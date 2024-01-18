import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class ComposantsSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Créer la fenêtre principale
            JFrame frame = new JFrame("Composants Swing");
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
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        // Créer et ajouter un composant JLabel
        JLabel label = new JLabel("JLabel : Affiche du texte et une icône");
        panel.add(label);

        // Créer et ajouter un composant JButton
        JButton button = new JButton("JButton : Déclenche une action par un clic");
        panel.add(button);

        // Créer et ajouter un composant JToggleButton
        JToggleButton toggleButton = new JToggleButton("JToggleButton : Bouton basculant");
        panel.add(toggleButton);

        // Créer et ajouter un composant JTextField
        JTextField textField = new JTextField("JTextField : Champ de saisie de texte simple");
        panel.add(textField);

        // Créer et ajouter un composant JPasswordField
        JPasswordField passwordField = new JPasswordField("JPasswordField : Champ de mot de passe");
        panel.add(passwordField);

        // Créer et ajouter un composant JTextArea
        JTextArea textArea = new JTextArea("JTextArea : Zone de saisie de texte");
        panel.add(textArea);

        // Créer et ajouter un composant JCheckBox
        JCheckBox checkBox = new JCheckBox("JCheckBox : Case à cocher");
        panel.add(checkBox);

        // Créer et ajouter un composant JRadioButton
        JRadioButton radioButton = new JRadioButton("JRadioButton : Item sélectionnable");
        panel.add(radioButton);

        // Créer et ajouter un composant JComboBox
        String[] elements = {"Élément 1", "Élément 2", "Élément 3"};
        JComboBox<String> comboBox = new JComboBox<>(elements);
        panel.add(comboBox);

        // Créer et ajouter un composant JList
        String[] listeElements = {"Élément A", "Élément B", "Élément C"};
        JList<String> list = new JList<>(listeElements);
        panel.add(new JScrollPane(list));

        // Créer et ajouter un composant JSpinner
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
        JSpinner spinner = new JSpinner(spinnerModel);
        panel.add(spinner);

        // Créer et ajouter un composant JSlider
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider);

        // Créer et ajouter un composant JProgressBar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);
        panel.add(progressBar);

        // Créer et ajouter un composant JTree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Racine");
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Enfant 1");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Enfant 2");
        root.add(child1);
        root.add(child2);
        JTree tree = new JTree(root);
        panel.add(new JScrollPane(tree));

        // Créer et ajouter un composant JTable
        String[][] data = {{"Donnée 1", "Donnée 2"}, {"Donnée 3", "Donnée 4"}};
        String[] columnNames = {"Colonne 1", "Colonne 2"};
        JTable table = new JTable(data, columnNames);
        panel.add(new JScrollPane(table));

        // Créer et ajouter un composant JScrollPane
        JTextPane textPane = new JTextPane();
        textPane.setText("JScrollPane : Conteneur avec barre de défilement");
        panel.add(new JScrollPane(textPane));

        // Créer et ajouter un composant JSplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(new JButton("Gauche"));
        splitPane.setRightComponent(new JButton("Droite"));
        panel.add(splitPane);
    }
}
