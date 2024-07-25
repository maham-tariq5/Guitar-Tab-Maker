import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    private static Tab guitarTab = new Tab();  // Create a Tab object to store the guitar tab notes

    public static void main(String[] args) {
        // Create the main frame for the GUI
        JFrame frame = new JFrame("Guitar Tab Creator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        Container container = frame.getContentPane();  // Get the content pane of the frame
        container.setLayout(new GridLayout(8, 1));  // Set the layout manager for the content pane

        // Create the components for the GUI
        JLabel label = new JLabel("Enter string (1-6) and fret number:");
        JTextField stringField = new JTextField();
        JTextField fretField = new JTextField();
        JButton addButton = new JButton("Add Note");
        JTextArea tabArea = new JTextArea();

        // Add action listener to the "Add Note" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the input from the text fields
                    int string = Integer.parseInt(stringField.getText());
                    int fret = Integer.parseInt(fretField.getText());

                    // Validate the input
                    if (string < 1 || string > 6) {
                        throw new IllegalArgumentException("String number must be between 1 and 6.");
                    }
                    if (fret < 0 || fret > 24) {
                        throw new IllegalArgumentException("Fret number must be between 0 and 24.");
                    }

                    // Add the note to the guitar tab and update the tab area
                    guitarTab.addNote(string, fret);
                    updateTabArea(tabArea);
                } catch (NumberFormatException ex) {
                    // Show error message if the input is not a valid number
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for string and fret.");
                } catch (IllegalArgumentException ex) {
                    // Show error message if the input is not within the valid range
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        // Adding the components to the container
        container.add(label);
        container.add(new JLabel("String:"));
        container.add(stringField);
        container.add(new JLabel("Fret:"));
        container.add(fretField);
        container.add(addButton);
        container.add(new JScrollPane(tabArea));  // Add a scroll pane for the tab area

        frame.setVisible(true);  // Make the frame visible
    }

    // Method to update the tab area with the current guitar tab notes
    private static void updateTabArea(JTextArea tabArea) {
        tabArea.setText("");  // Clear the current text
        for (String line : guitarTab.getTabLines()) {
            tabArea.append(line + "\n");  // Append each line of the guitar tab to the text area
        }
    }
}

