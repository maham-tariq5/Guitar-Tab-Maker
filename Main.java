import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Tab guitarTab = new Tab();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Guitar Tab Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        Container container = frame.getContentPane();
        container.setLayout(new GridLayout(8, 1));

        JLabel label = new JLabel("Enter string (1-6) and fret number:");
        JTextField stringField = new JTextField();
        JTextField fretField = new JTextField();
        JButton addButton = new JButton("Add Note");
        JTextArea tabArea = new JTextArea();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int string = Integer.parseInt(stringField.getText());
                int fret = Integer.parseInt(fretField.getText());
                guitarTab.addNote(string, fret);
                updateTabArea(tabArea);
            }
        });

        container.add(label);
        container.add(new JLabel("String:"));
        container.add(stringField);
        container.add(new JLabel("Fret:"));
        container.add(fretField);
        container.add(addButton);
        container.add(new JScrollPane(tabArea));

        frame.setVisible(true);
    }

    private static void updateTabArea(JTextArea tabArea) {
        tabArea.setText("");
        for (String line : guitarTab.getTabLines()) {
            tabArea.append(line + "\n");
        }
    }
}