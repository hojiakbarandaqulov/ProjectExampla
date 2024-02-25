package com.company.SecondUnit;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class SecondMain {
    public static HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .build();

    public static void main(String[] args) {

        User user =login("alish", "12345");
        String token = user.getAccessToken();

        Card card = new Card();
        card.setCardNumber("12349999");
        card.setBalance(5600l);

        createCard(card, token);

//        registration();
    }

    public static void createCard(Card card, String token) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(card);

            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .uri(URI.create("http://localhost:12349999/card"))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println(response.body());
            } else {
                System.out.println(response.statusCode());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static User login(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);


        Gson gson = new Gson();
        String json = gson.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .uri(URI.create("http://localhost:12349999/auth/login"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                User user1 = gson.fromJson(response.body(), User.class);
                return user1;
            } else {
                System.out.println(response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public static void registration() {

        User user = new User();
        user.setName("Alish");
        user.setSurname("Aliyev");
        user.setLogin("alish");
        user.setPassword("12345");


        Gson gson = new Gson();
        String json = gson.toJson(user);

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .uri(URI.create("http://localhost:12349999/auth/registration"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println(response.body());
            } else {
                System.out.println(response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void test() {
        //        HttpClient httpClient = HttpClient.newHttpClient();

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.headers());
            if (response.statusCode() == 200) {
                System.out.println(response.body());
            } else {
                System.out.println(response.statusCode());
            }
//            System.out.println(response.uri().getHost());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
