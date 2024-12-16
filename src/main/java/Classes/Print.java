package Classes;

import Jokes.Joke;
import Jokes.JokeGroup;
import Users.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static Classes.JokesApi.GetJokesByType;
import static Classes.JokesApi.GetJokesRandom;
import static Classes.RandomUserApi.GetUserJson;
import static Classes.RandomUserApi.GetUserXml;
import static Jokes.JokeGroup.groupJokesByType;
import static Users.FullUser.getFullUsers;

public class Print
{

    public static void print1_1() throws IOException, InterruptedException
    {
        PrintWriter out = new PrintWriter("src/main/java/Data/SourceJokes.json");
        String temp = GetJokesRandom();
        out.println(temp);
        out.close();

        out = new PrintWriter("src/main/java/Data/File1_1.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Joke> jokes = objectMapper.readerForListOf(Joke.class).readValue(temp);

        ArrayList<JokeGroup> groupedJokes = groupJokesByType(jokes);

        temp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupedJokes);
        out.println(temp);
        out.close();
    }

    /**
     * @param MAX_N расчитывается по формуле: MAX_N = MAX_N * 10 для каждого типа
     */
    public static void print1_2(int MAX_N) throws IOException, InterruptedException
    {
        PrintWriter out = new PrintWriter("src/main/java/Data/SourceJokes.json");
        String temp = GetJokesByType(MAX_N);
        out.println(temp);
        out.close();

        out = new PrintWriter("src/main/java/Data/File1_2.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Joke> jokes = objectMapper.readerForListOf(Joke.class).readValue(temp);

        ArrayList<JokeGroup> groupedJokes = groupJokesByType(jokes);

        temp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(groupedJokes);
        out.println(temp);
        out.close();
    }

    public static void print2_1() throws IOException, InterruptedException
    {
        PrintWriter out = new PrintWriter("src/main/java/Data/SourceUsers.json");
        String temp = GetUserJson();
        out.println(temp);
        out.close();

        out = new PrintWriter("src/main/java/Data/File2_1.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ArrayList<User> users = objectMapper.readerForListOf(User.class).readValue(temp);

        ArrayList<FullUser> fullUsers = getFullUsers(users);

        temp = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fullUsers);
        out.println(temp);
        out.close();
    }

    public static void print2_2() throws IOException, InterruptedException, JAXBException
    {
        PrintWriter out = new PrintWriter("src/main/java/Data/SourceUsers.xml");
        String temp = GetUserXml();
        out.println(temp);
        out.close();

        BufferedReader br = new BufferedReader(new FileReader("src/main/java/Data/SourceUsers.xml"));
        String body = br.lines().collect(Collectors.joining());
        StringReader reader = new StringReader(body);

        JAXBContext context = JAXBContext.newInstance(Results.class, User.class, ArrayList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Results results = (Results) unmarshaller.unmarshal(reader);

        FullResults fullResults = getFullUsers(results);

        context = JAXBContext.newInstance(FullResults.class);
        out = new PrintWriter("src/main/java/Data/File2_2.xml");
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(fullResults, out);
        out.close();
    }
}
