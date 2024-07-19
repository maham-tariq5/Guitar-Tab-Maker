import java.util.ArrayList;
import java.util.List;

public class Tab {
    private List<String> tabLines;

    // Constructor to initialize the tab with six empty strings (one for each guitar string)
    public Tab() {
        tabLines = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tabLines.add("");
        }
    }

      // Method to add a note to a specified string at a specified fret
    public void addNote(int string, int fret) {
        if (string < 1 || string > 6) {
            throw new IllegalArgumentException("Invalid string number");
        }
        
        // Determine the maximum length of the existing lines
        int maxLength = 0;
        for (String line : tabLines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        
        // Pad each line with hyphens to make all lines the same length
        for (int i = 0; i < tabLines.size(); i++) {
            StringBuilder line = new StringBuilder(tabLines.get(i));
            while (line.length() < maxLength) {
                line.append("-");
            }
            tabLines.set(i, line.toString());
        }
        
        // Append the new note to the specified string
        StringBuilder stringLine = new StringBuilder(tabLines.get(string - 1));
        stringLine.append(fret);
        tabLines.set(string - 1, stringLine.toString());

        // Add hyphens to the other lines to keep them aligned
        for (int i = 0; i < tabLines.size(); i++) {
            if (i != string - 1) {
                tabLines.set(i, tabLines.get(i) + "-");
            }
        }
    }

    public List<String> getTabLines() {
        return tabLines;
    }

    public void printTab() {
        for (String line : tabLines) {
            System.out.println(line);
        }
    }
}
