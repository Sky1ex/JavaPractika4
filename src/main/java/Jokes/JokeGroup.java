package Jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JokeGroup
{
    private String type;
    private List<JokeText> jokes;

    public JokeGroup(String type, List<JokeText> jokes) {
        this.type = type;
        this.jokes = jokes;
    }

    public String getType() {
        return type;
    }

    public List<JokeText> getJokes() {
        return jokes;
    }

    public static ArrayList<JokeGroup> groupJokesByType(ArrayList<Joke> jokes)
    {
        return (ArrayList<JokeGroup>) jokes.stream()
                .collect(Collectors.groupingBy(Joke::getType))
                .entrySet().stream()
                .map(entry -> new JokeGroup(
                        entry.getKey(),
                        entry.getValue().stream()
                                .map(joke -> new JokeText(joke.getId(), joke.getSetup() + " " + joke.getPunchline()))
                                .distinct()
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Type: " + type + "\nJokes:\n" + jokes + "\n";
    }
}
