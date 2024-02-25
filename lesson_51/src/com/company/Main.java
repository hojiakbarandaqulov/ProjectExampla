package com.company;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(10)).build();

    public static void main(String[] args) {
//        com.company.User user = new com.company.User("Ali", "Aliyev", "ali1", "12345");

//        registration(user);
        User user = login("ali1", "12345");

        String accessToken = user.getAccessToken();
        /*Card card = new Card();
        card.setBalance(5600l);
        card.setCardNumber("3333");
        createCard(card, accessToken);*/

        Card card = getCardById("5cac862a-19d1-4b51-813f-1710f9a4cb06", accessToken);
        System.out.println(card);
    }

    public static Card getCardById(String id, String token) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("Authorization", "Bearer " + token)
                    .uri(URI.create("http://localhost:8081/card/" + id))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Card card = gson.fromJson(response.body(), Card.class);
                return card;
            } else {
                System.out.println(response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void createCard(Card card, String token) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(card);

            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .uri(URI.create("http://localhost:8081/card"))
                    .build();

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

    public static void registration(User user) {
        try {
            user.setId(UUID.randomUUID().toString());
            Gson gson = new Gson();
            String json = gson.toJson(user);


            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .uri(URI.create("http://localhost:8081/auth/registration"))
                    .build();

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


    public static User login(String login, String password) {
        // localhost:8081/auth/login  POST  {login:123123,password:12312"}
        try {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);

            Gson gson = new Gson();
            String json = gson.toJson(user);

            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .uri(URI.create("http://localhost:8081/auth/login"))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {

                User responseUser = gson.fromJson(response.body(), User.class);
                return responseUser;
            } else {
                System.out.println(response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static void UpdateCardStatus(String id, String accessToken) {
        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .PUT(HttpRequest.BodyPublishers.noBody())
                    .header("Authorization", "Bearer " + accessToken)
                    .uri(URI.create("http://localhost:8081/card/status/" + id))
                    .build();

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

}