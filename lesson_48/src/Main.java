import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        /*try {
            URL url = new URL("https://dasturlash.uz/resources");

            System.out.println("URL is " + url);
            System.out.println("protocol is " + url.getProtocol());
            System.out.println("authority is " + url.getAuthority());
            System.out.println("file name is " + url.getFile());
            System.out.println("host is " + url.getHost());
            System.out.println("path is " + url.getPath());
            System.out.println("port is " + url.getPort());
            System.out.println("default port is " + url.getDefaultPort());
            System.out.println("query is " + url.getQuery());
            System.out.println("ref is " + url.getRef());

        } catch (IOException e) {
            e.printStackTrace();
        }*/
       /* try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/USD/2022-12-10/");
            URLConnection connection = url.openConnection();

            InputStream stream = connection.getInputStream();

            int i;
            while ((i = stream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
       /* try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/USD/2022-12-10/");
            URLConnection connection = url.openConnection();

            InputStream stream = connection.getInputStream();

            int i;
            while ((i = stream.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
      /*  try {
            try {
                URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/USD/2024-01-16/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                System.out.println("------------- Header Info -------------");


                for (int i = 1; i <= 8; i++) {
                    System.out.println(connection.getHeaderFieldKey(i) + " = " + connection.getHeaderField(i));
                }
                System.out.println("------------- Other Info -------------");
                System.out.println("RequestMethod: " + connection.getRequestMethod());
                System.out.println("RequestMethod: " + connection.getResponseCode());
                System.out.println("RequestMethod: " + connection.getResponseMessage());

                System.out.println("---------------------------------");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line = bufferedReader.readLine();
                while (line != null) {
                    System.out.print(line);
                    line = bufferedReader.readLine();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            *//*InputStream stream = connection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len = stream.available();
            byte[] data = new byte[len];
            int n;

            while ((n = stream.read(data)) > 0) {
                baos.write(data, 0, n);
            }
             String content = new String(baos.toByteArray(), "UTF-8");
            System.out.println(content);
            *//*
        } catch (Exception ex) {
            ex.printStackTrace();
        }
*/
        URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Tashkent&APPID=99359aa7c82d931dc451734dea583180");

        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        for (int i = 1; i <= 8; i++) {
            System.out.println(connection.getHeaderFieldKey(i) + " = " + connection.getHeaderField(i));
        }
    }
}