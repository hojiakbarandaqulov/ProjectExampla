import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

    }
    public static void post() {
        try {
            URL url = new URL("http://192.168.0.104:8081/student");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String jsonInputString = "{\n" +
                    "    \"name\" :\"Vali\",\n" +
                    "    \"surname\": \"Valiyev\",\n" +
                    "    \"age\" : \"19\"\n" +
                    "  }";

            byte[] input = jsonInputString.getBytes("utf-8");
            OutputStream os = connection.getOutputStream();
            os.write(input, 0, input.length);


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(connection.getResponseCode());

            String line = bufferedReader.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                builder.append(line);
                line = bufferedReader.readLine();
            }
            System.out.println(builder);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}