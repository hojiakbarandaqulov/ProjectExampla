package com.company;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.imageio.IIOException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        weather();
    }

    public static void getWeather_2() {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Tashkent&APPID=99359aa7c82d931dc451734dea583180&units=metric");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);


            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();



            JSONObject jsonObject = (JSONObject) JSONValue.parse(sb.toString());

            JSONObject main = (JSONObject) jsonObject.get("main");
            Double temp = (Double) main.get("temp");
            Temperature temperature = new Temperature();
            temperature.setTemp(temp);


            JSONArray array = (JSONArray) jsonObject.get("weather");
            for(Object jb : array){
                JSONObject jbObj = (JSONObject) jb;
                System.out.println(jbObj.get("icon"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void weather() {
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Tashkent&APPID=99359aa7c82d931dc451734dea583180&units=metric");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);


            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();

            Gson gson = new Gson();

            Weather weather = gson.fromJson(sb.toString(), Weather.class);
            System.out.println(weather);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}