import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Tab {
    private List<String> tabLines;

    public Tab() {
        tabLines = new ArrayList<>();
        // Initialize with six empty strings for six guitar strings
        for (int i = 0; i < 6; i++) {
            tabLines.add("");
        }
    }

    public List<String> getTabLines() {
        return tabLines;
    }

    public void addNote(int string, int fret) {
        if (string < 1 || string > 6) {
            throw new IllegalArgumentException("Invalid string number");
        }
        String line = tabLines.get(string - 1);
        line += fret + "-";
        tabLines.set(string - 1, line);
    }

    public void printTab() {
        for (String line : tabLines) {
            System.out.println(line);
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : tabLines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
    
    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            tabLines.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                tabLines.add(line);
            }
        }
    }



}
