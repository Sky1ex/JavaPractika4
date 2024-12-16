package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RandomUserApi
{
    private static final int CONNECTION_TIMEOUT = 5000;

    public static String GetUserJson() throws IOException, InterruptedException
    {
        StringBuilder content = new StringBuilder();

        final URL url = new URL("https://randomuser.me/api/?inc=name,%20location,%20email,%20phone,%20picture&results=10");
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
                inputLine = inputLine.substring(inputLine.indexOf("["), inputLine.indexOf("]")+1);
                content.append(inputLine);
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
            return "";
        }
        return content.toString();
    }

    public static String GetUserXml() throws IOException, InterruptedException
    {
        StringBuilder content = new StringBuilder();

        final URL url = new URL("https://randomuser.me/api/?inc=name,%20location,%20email,%20phone,%20picture&results=10&format=xml");
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
        String result = content.toString();
        result = result.substring(result.indexOf("<user>")+6, result.indexOf("<info>"));
        result = result.replaceAll("<results>", "<user>");
        result = result.replaceAll("</results>", "</user>");
        result = "<results>" + result + "</results>";
        return result;
    }
}
