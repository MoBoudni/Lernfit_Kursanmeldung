package de.lernfit;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class LuftWasserGUI extends JFrame {
	
    private JTextField nameField;
    private JComboBox<String> kursComboBox;
    private JComboBox<String> bundeslandComboBox;
    private JSpinner wasserSpinner;
    private JTextArea summaryArea;

    private String[] kurse = {"Java", "Python", "C#", "Javascript", "C++", "C", "Ruby", "Golang", "Typescript"};
    private String[] bundeslaender = {
        "Baden-Württemberg", "Bayern", "Berlin", "Brandenburg", "Bremen",
        "Hamburg", "Hessen", "Mecklenburg-Vorpommern", "Niedersachsen",
        "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland", "Sachsen",
        "Sachsen-Anhalt", "Schleswig-Holstein", "Thüringen"
    };

    public LuftWasserGUI() {
        setTitle("LernFit - Kursanmeldung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));

        // Main Panel mit Padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        nameField = new JTextField(20);
        mainPanel.add(nameField, gbc);

        // Kurs
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Kurs:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        kursComboBox = new JComboBox<>(kurse);
        mainPanel.add(kursComboBox, gbc);

        // Bundesland
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Bundesland:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        bundeslandComboBox = new JComboBox<>(bundeslaender);
        mainPanel.add(bundeslandComboBox, gbc);

        // Wasser-Erinnerung
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        mainPanel.add(new JLabel("Wasser-Erinnerung (Minuten):"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(60, 15, 240, 15);
        wasserSpinner = new JSpinner(spinnerModel);
        mainPanel.add(wasserSpinner, gbc);

        // Zusammenfassung
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;
        summaryArea = new JTextArea(5, 30);
        summaryArea.setEditable(false);
        summaryArea.setLineWrap(true);
        summaryArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(summaryArea);
        mainPanel.add(scrollPane, gbc);

        // Button Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton submitButton = new JButton("Bestätigen");
        JButton resetButton = new JButton("Neu starten");

        submitButton.addActionListener(e -> updateSummary());
        resetButton.addActionListener(e -> resetForm());

        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);

        // Add panels to frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set window properties
        pack();
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500, 600));
    }

    private void updateSummary() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Bitte geben Sie Ihren Namen ein.",
                "Fehlende Eingabe",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!isValidName(name)) {
            JOptionPane.showMessageDialog(this,
                "Ungültiger Name. Bitte geben Sie nur Buchstaben ein.",
                "Ungültige Eingabe",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String kurs = (String) kursComboBox.getSelectedItem();
        String bundesland = (String) bundeslandComboBox.getSelectedItem();
        int wasserInterval = (Integer) wasserSpinner.getValue();
        int kursDauer = kurs.equals("Java") ? 30 : 60;

        StringBuilder summary = new StringBuilder();
        summary.append("Hallo ").append(name).append(",\n\n");
        summary.append("Du hast dich für den ").append(kurs).append("-Kurs entschieden.\n");
        summary.append("Die Veranstaltung findet in ").append(bundesland)
               .append(" statt und geht ").append(kursDauer).append(" Werktage (MO - FR) lang.\n");
        summary.append("Du möchtest alle ").append(wasserInterval)
               .append(" Minuten höflich daran erinnert werden, dass Du Wasser trinken solltest.");

        summaryArea.setText(summary.toString());
    }

    private void resetForm() {
        nameField.setText("");
        kursComboBox.setSelectedIndex(0);
        bundeslandComboBox.setSelectedIndex(0);
        wasserSpinner.setValue(60);
        summaryArea.setText("");
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // Set System Look and Feel
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new LuftWasserGUI().setVisible(true);
        });
    }
}



//package de.lernfit;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.border.EmptyBorder;
//
//public class LuftWasserGUI extends JFrame {
//    private JTextField nameField;
//    private JComboBox<String> kursComboBox;
//    private JComboBox<String> bundeslandComboBox;
//    private JSpinner wasserSpinner;
//    private JTextArea summaryArea;
//    
//    private String[] kurse = {"Java", "Python", "C#" , "Javascript" , "C++" , "C", "Ruby", "Golang" , "Typescript"};
//    private String[] bundeslaender = {
//        "Baden-Württemberg", "Bayern", "Berlin", "Brandenburg", "Bremen",
//        "Hamburg", "Hessen", "Mecklenburg-Vorpommern", "Niedersachsen",
//        "Nordrhein-Westfalen", "Rheinland-Pfalz", "Saarland", "Sachsen",
//        "Sachsen-Anhalt", "Schleswig-Holstein", "Thüringen"
//    };
//
//    public LuftWasserGUI() {
//        setTitle("LernFit - Kursanmeldung");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout(20, 20));
//        
//        // Main Panel mit Padding
//        JPanel mainPanel = new JPanel(new GridBagLayout());
//        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.insets = new Insets(5, 5, 5, 5);
//        
//        // Name
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        mainPanel.add(new JLabel("Name:"), gbc);
//        
//        gbc.gridx = 1;
//        gbc.weightx = 1.0;
//        nameField = new JTextField(20);
//        mainPanel.add(nameField, gbc);
//        
//        // Kurs
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.weightx = 0.0;
//        mainPanel.add(new JLabel("Kurs:"), gbc);
//        
//        gbc.gridx = 1;
//        gbc.weightx = 1.0;
//        kursComboBox = new JComboBox<>(kurse);
//        mainPanel.add(kursComboBox, gbc);
//        
//        // Bundesland
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        gbc.weightx = 0.0;
//        mainPanel.add(new JLabel("Bundesland:"), gbc);
//        
//        gbc.gridx = 1;
//        gbc.weightx = 1.0;
//        bundeslandComboBox = new JComboBox<>(bundeslaender);
//        mainPanel.add(bundeslandComboBox, gbc);
//        
//        // Wasser-Erinnerung
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        gbc.weightx = 0.0;
//        mainPanel.add(new JLabel("Wasser-Erinnerung (Minuten):"), gbc);
//        
//        gbc.gridx = 1;
//        gbc.weightx = 1.0;
//        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(60, 15, 240, 15);
//        wasserSpinner = new JSpinner(spinnerModel);
//        mainPanel.add(wasserSpinner, gbc);
//        
//        // Zusammenfassung
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        gbc.gridwidth = 2;
//        gbc.weighty = 1.0;
//        summaryArea = new JTextArea(5, 30);
//        summaryArea.setEditable(false);
//        summaryArea.setLineWrap(true);
//        summaryArea.setWrapStyleWord(true);
//        JScrollPane scrollPane = new JScrollPane(summaryArea);
//        mainPanel.add(scrollPane, gbc);
//        
//        // Button Panel
//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
//        JButton submitButton = new JButton("Bestätigen");
//        JButton resetButton = new JButton("Neu starten");
//        
//        submitButton.addActionListener(e -> updateSummary());
//        resetButton.addActionListener(e -> resetForm());
//        
//        buttonPanel.add(submitButton);
//        buttonPanel.add(resetButton);
//        
//        // Add panels to frame
//        add(mainPanel, BorderLayout.CENTER);
//        add(buttonPanel, BorderLayout.SOUTH);
//        
//        // Set window properties
//        pack();
//        setLocationRelativeTo(null);
//        setMinimumSize(new Dimension(500, 600));
//    }
//    
//    private void updateSummary() {
//        String name = nameField.getText().trim();
//        if (name.isEmpty()) {
//            JOptionPane.showMessageDialog(this, 
//                "Bitte geben Sie Ihren Namen ein.", 
//                "Fehlende Eingabe", 
//                JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        
//        String kurs = (String) kursComboBox.getSelectedItem();
//        String bundesland = (String) bundeslandComboBox.getSelectedItem();
//        int wasserInterval = (Integer) wasserSpinner.getValue();
//        int kursDauer = kurs.equals("Java") ? 30 : 60;
//        
//        StringBuilder summary = new StringBuilder();
//        summary.append("Hallo ").append(name).append(",\n\n");
//        summary.append("Du hast dich für den ").append(kurs).append("-Kurs entschieden.\n");
//        summary.append("Die Veranstaltung findet in ").append(bundesland)
//               .append(" statt und geht ").append(kursDauer).append(" Werktage (MO - FR) lang.\n");
//        summary.append("Du möchtest alle ").append(wasserInterval)
//               .append(" Minuten höflich daran erinnert werden, dass Du Wasser trinken solltest.");
//        
//        summaryArea.setText(summary.toString());
//    }
//    
//    private void resetForm() {
//        nameField.setText("");
//        kursComboBox.setSelectedIndex(0);
//        bundeslandComboBox.setSelectedIndex(0);
//        wasserSpinner.setValue(60);
//        summaryArea.setText("");
//    }
//    
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                // Set System Look and Feel
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            new LuftWasserGUI().setVisible(true);
//        });
//    }
//}
//
