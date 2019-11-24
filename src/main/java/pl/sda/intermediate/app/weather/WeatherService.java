package pl.sda.intermediate.app.weather;

import com.google.gson.Gson;
import pl.sda.intermediate.app.users.User;
import pl.sda.intermediate.app.users.UserContextHolder;
import pl.sda.intermediate.app.users.UserDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WeatherService {

    private String apiKey = "ea900b66f547fd7b23625544873a4200";
    private UserDAO userDAO;

    public WeatherService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public WeatherWrapper getWeatherForCurrentUser() {
        String userLoggedIn = UserContextHolder.getUserLoggedIn();
        User user = userDAO.findUserByEmail(userLoggedIn).orElse(null);
        String userCity = user.getCity();
        String userCountry = user.getCountry().toLowerCase();

        String json = downloadText(
                "https://api.openweathermap.org/data/2.5/weather?q="
                        + userCity + "," + userCountry + "&appid=" + apiKey+"&units=metric&lang="+userCountry);
        Gson gson = new Gson();
        return gson.fromJson(json, WeatherWrapper.class);
    }

    private String downloadText(String address) {
        try {
            URL url = new URL(address);
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bR = new BufferedReader(inputStreamReader);

            String line = "";
            String lines = "";
            while ((line = bR.readLine()) != null) {
                lines += line;
            }
            return lines;
        } catch (IOException e) {
            return "";
        }
    }

}
