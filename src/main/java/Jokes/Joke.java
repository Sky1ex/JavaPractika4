package Jokes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Joke
{
    private String type;
    private String setup;
    private String punchline;
    private int id;

    @Override
    public String toString()
    {
        return "type: " + type + "\n" +
                "setup: " + setup + "\n" +
                "punchline" + punchline + "\n" +
                "id: " + id + "\n";
    }
}
