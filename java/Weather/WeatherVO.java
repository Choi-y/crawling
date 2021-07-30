package Weather;

public class WeatherVO {
    private String gu;
    private String temperature;
    private String weather;

    public WeatherVO(String gu, String temperature, String weather) {
        this.gu = gu;
        this.temperature = temperature;
        this.weather = weather;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
