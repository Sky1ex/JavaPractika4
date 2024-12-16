package Jokes;

public class JokeText {
    private int id;
    private String text;

    public JokeText(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Text: " + text + "\n";
    }
}
