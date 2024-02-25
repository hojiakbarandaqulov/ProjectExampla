package Http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Http {
    public static void main(String[] args) {
//        post();
      /*  getOne("3c4bfd06-bd15-4ea3-a731-80eb93b226c2");*/
        delete("24c516cb-b797-4814-bb00-85cbd7cf76d9");
    }
    public static void delete(String id) {
        try {
            URL url = new URL("http://localhost:8081/student/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = bufferedReader.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                builder.append(line);
                line = bufferedReader.readLine();
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void getOne(String id) {
        try {
            URL url = new URL("http://localhost:8081/student/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = bufferedReader.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                builder.append(line);
                line = bufferedReader.readLine();
            }
            System.out.println(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

  /*  public static void post() {
        try {
            URL url = new URL("http://192.168.0.104:8081/student");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);

            String jsonInputString = "{\n" +
                    "    \"name\" :\"Eshmat\",\n" +
                    "    \"surname\": \"Eshmatov\",\n" +
                    "    \"age\" : \"23\"\n" +
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
    }*/

}
