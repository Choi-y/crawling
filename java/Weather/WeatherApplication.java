package Weather;

import java.util.ArrayList;

public class WeatherApplication {
    public static void main(String[] args) {
        ArrayList<WeatherVO> WV = new ArrayList<WeatherVO>();

        WeatherDAO.WeatherCrawling(WV);
        DbDAO.UploadToDB(WV);
    }
}
