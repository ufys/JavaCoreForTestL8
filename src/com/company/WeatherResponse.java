package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherResponse {
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void parseCurrentWeatherJson(String resultJson) {
        try {
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get ("DailyForecasts", "Headline", "Maximum", "Minimum");
            JSONObject weatherData = (JSONObject) weatherArray.get(0);
            JSONObject weatherText = (JSONObject) weatherArray.get(3);
            JSONObject weatherMAX = (JSONObject) weatherArray.get(0);
            JSONObject weatherMIN = (JSONObject) weatherArray.get(0);


            System.out.println ("В городе - " + '\'' +
                    "на дату: " + weatherData.get("Date") + '\'' +
                    "ожидается: " + weatherText.get("Text") + '\'' +
                    "температура: " + (weatherMAX.get("Value")+weatherMIN.get("Value")/2−32×5/9);
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
