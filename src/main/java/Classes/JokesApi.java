package Classes;

import Jokes.Joke;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class JokesApi
{
    private static final int CONNECTION_TIMEOUT = 5000;

    public static String GetJokesRandom() throws IOException, InterruptedException {
        StringBuilder content = new StringBuilder();

            final URL url = new URL("https://official-joke-api.appspot.com/jokes/random/100");
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(CONNECTION_TIMEOUT);
            con.setReadTimeout(CONNECTION_TIMEOUT);

            try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())))
            {
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                {
                    content.append(inputLine);
                }
            } catch (final Exception ex) {
                ex.printStackTrace();
                return "";
            }
        return content.toString();
    }

    public static String GetJokesByType(int MAX_N) throws IOException, InterruptedException {
        StringBuilder content = new StringBuilder();

        URL url = new URL("https://official-joke-api.appspot.com/types");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(CONNECTION_TIMEOUT);
        con.setReadTimeout(CONNECTION_TIMEOUT);

        BufferedReader types = new BufferedReader(new InputStreamReader(con.getInputStream()));
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> arrayList = objectMapper.readerForListOf(String.class).readValue(types.readLine());

        for(String temp : arrayList)
        {
            for (int i = 0; i < MAX_N; i++)
            {
                url = new URL("https://official-joke-api.appspot.com/jokes/" + temp + "/ten");
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.setConnectTimeout(CONNECTION_TIMEOUT);
                con.setReadTimeout(CONNECTION_TIMEOUT);

                try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())))
                {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null)
                    {
                        content.append(inputLine);
                    }
                } catch (final Exception ex) {
                    ex.printStackTrace();
                    return "";
                }
                if(!(temp == arrayList.get(arrayList.size()-1) && i == MAX_N-1)) content.append(", ");
                Thread.sleep(500);
                System.out.println("Соединение: " + (i+1) + " по типу: " + temp);
            }
        }
        String result = content.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("]", "");
        result = "[" + result + "]";
        return result;
    }
}
