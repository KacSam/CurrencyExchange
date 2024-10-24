package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataProvider {
    private static DataProvider dataProvider = null;


    private DataProvider(){}

    public static DataProvider getInstance(){
        if (dataProvider==null){
            dataProvider = new DataProvider();
        }
        return dataProvider;
    }
    public String getData(String urlString) throws Exception{
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/xml");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
            }
        } else {
            throw new Exception("Nie udalo sie pobrac API. Kod odpowiedzi: " + responseCode);
        }

        return result.toString();
    }
}
