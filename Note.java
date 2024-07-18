public class Note {
    private int string;
    private int fret;

    public Note(int string, int fret) {
        this.string = string;
        this.fret = fret;
    }

    public int getString() {
        return string;
    }

    public int getFret() {
        return fret;
    }

    @Override
    public String toString() {
        return "String: " + string + ", Fret: " + fret;
    }
}
