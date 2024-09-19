
import javax.servlet.http.Cookie;

public class WeatherData {

    private String city, wind, date, humidity, temperature, condition;
    private Cookie found;

    public Cookie getFound() {
        return found;
    }

    public void setFound(Cookie found) {
        this.found = found;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city.substring(1, city.length() - 1);
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition.toLowerCase().substring(1, condition.length() - 1);
    }
}
