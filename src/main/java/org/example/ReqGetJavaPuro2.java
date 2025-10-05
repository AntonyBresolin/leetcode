package org.example;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class ReqGetJavaPuro2 {
    public static void main(String[] args) {
        String urlString = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m";
        String cep = "85937-000";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("application", "Accepted");

            if (connection.getResponseCode() == 200) {
                StringBuilder in = new StringBuilder();
                BufferedReader response = new BufferedReader(
                        new InputStreamReader(connection.getInputStream())
                );

                String inputLine = "";
                while ((inputLine = response.readLine()) != null) {
                    in.append(inputLine);
                }
                System.out.println(in);

            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
