
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import javax.servlet.http.Cookie;

public class WeatherAPI {

    private final String key = "73934f9ec4eb2d88922b2695951c1514";

    public WeatherData getWeatheDataOf(String city) throws IOException {
        WeatherData data = new WeatherData();
        String src = "https://api.openweathermap.org/data/2.5/weather?units=metric&appid=" + key + "&q=" + city;

        Cookie found = new Cookie("found", "passed");

        // API Integration
        // 1. Make a URL
        URL url = new URL(src);

        // 2. Create Connection of the URL
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // 3. Set the method type "GET"
        con.setRequestMethod("GET");

        // 4. Check the Response
        int httpResponse = con.getResponseCode();

        if (httpResponse != con.HTTP_OK) {
            city = "Bhopal"; // default city
            src = "https://api.openweathermap.org/data/2.5/weather?units=metric&appid=" + key + "&q=" + city;

            // Repeat the 1, 2 and 3 step again
            url = new URL(src);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            found = new Cookie("found", "failed");
        }

        // 5. Make a input reader
        InputStream is = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        // 6. Store the data
        StringBuilder sbData = new StringBuilder();

        try {
            String line;

            while ((line = br.readLine()) != null) {
                sbData.append(line);
            }

        } catch (IOException ex) {
            System.out.println("Error in storing the file...");
            ex.printStackTrace();
        }

        br.close();

        // 7. Convert the StringBuilder data to JSON
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(sbData.toString(), JsonObject.class);

        // 8. fetching the data from JSON
        // Date
        long ms = json.get("dt").getAsLong() * 1000;
        data.setDate(new Date(ms).toString());

        // Temperature
        data.setTemperature(String.valueOf(json.getAsJsonObject("main").get("temp").getAsInt()));

        // Humidity
        data.setHumidity(String.valueOf(json.getAsJsonObject("main").get("humidity").getAsInt()));

        // Wind Speed
        data.setWind(String.valueOf(json.getAsJsonObject("wind").get("speed").getAsInt()));

        // Weather condition
        data.setCondition(json.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").toString());

        // City Name
        data.setCity(json.get("name").toString());

        // Cookie
        data.setFound(found);

        // 9. Return the Data
        return data;
    }

}
