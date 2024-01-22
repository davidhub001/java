import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Calendrier {
    private static JTextArea textArea;
    private static JTextField yearField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Calendrier avec Numéros de Semaine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel controlsPanel = new JPanel();
        yearField = new JTextField(6);
        controlsPanel.add(new JLabel("Année:"));
        controlsPanel.add(yearField);

        JButton showCalendarButton = new JButton("Afficher Calendrier");
        showCalendarButton.addActionListener(e -> afficherCalendrierAvecSemaines());
        controlsPanel.add(showCalendarButton);

        frame.add(controlsPanel, BorderLayout.NORTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void afficherCalendrierAvecSemaines() {
        try {
            int selectedYear = Integer.parseInt(yearField.getText().trim());

            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            calendar.setMinimalDaysInFirstWeek(4);
            calendar.set(Calendar.YEAR, selectedYear);

            StringBuilder calendarText = new StringBuilder();

            for (int mois = 0; mois < 12; mois++) {
                calendar.set(Calendar.MONTH, mois);

                SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy", Locale.FRENCH);
                String monthYear = sdf.format(calendar.getTime());

                calendarText.append("+------------------------------------------------+\n");
                calendarText.append(String.format("|                     %s                      |\n", monthYear));
                calendarText.append("+-----+-----+-----+-----+-----+-----+-----+-----+\n");
                calendarText.append("| Sem | Lun | Mar | Mer | Jeu | Ven | Sam | Dim |\n");
                calendarText.append("+-----+-----+-----+-----+-----+-----+-----+-----+\n");

                int firstDayWeekNumber = calendar.get(Calendar.WEEK_OF_YEAR);

                int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                int currentWeekNumber = firstDayWeekNumber;

                for (int day = 1; day <= daysInMonth; day++) {
                    int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                    if (currentDayOfWeek == Calendar.MONDAY) {
                        calendarText.append(String.format("|%4d |", currentWeekNumber));
                    } else if (day == 1) {
                        calendarText.append("|     |");
                    }

                    calendarText.append(String.format(" %3d |", day));

                    if (currentDayOfWeek == Calendar.SUNDAY) {
                        calendarText.append("\n+-----+-----+-----+-----+-----+-----+-----+-----+\n");
                        currentWeekNumber++;
                    }

                    calendar.add(Calendar.DAY_OF_MONTH, 1);
                }

                calendar.set(Calendar.WEEK_OF_YEAR, firstDayWeekNumber);
            }

            textArea.setText(calendarText.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer une année valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
