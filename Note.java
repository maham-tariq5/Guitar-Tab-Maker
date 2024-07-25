
public class Note {
    private int string;  
    private int fret;    

    // Constructor to initialize a Note object with the given string and fret
    public Note(int string, int fret) {
        this.string = string;  // Set the string number
        this.fret = fret;      // Set the fret number
    }

    // Getter method to retrieve the string number
    public int getString() {
        return string;
    }

    // Getter method to retrieve the fret number
    public int getFret() {
        return fret;
    }

    // Override the toString method to provide a string representation of the Note
    @Override
    public String toString() {
        return "String: " + string + ", Fret: " + fret;
    }
}
