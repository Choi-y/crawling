package Weather;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class WeatherDAO {
    static void WeatherCrawling(ArrayList<WeatherVO> WV) {
        String url = "https://search.naver.com/search.naver?query=**동날씨";
        Document doc = null;
        Elements tmp;
        String gu = "**구";
        String temperature = null;
        String weather = null;
        String tmp2 = null;
        int index = 0;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements element = doc.select("p.info_temperature");

        System.out.println("== == == == == == == ==");
        Iterator<Element> ie1 = element.select("span.todaytemp").iterator();

        System.out.println(ie1.next().text());
        temperature = ie1.next().text();

        System.out.println("== == == == == == == ==");

        element = doc.select("ul.info_list");
        ie1 = element.select("p.cast_txt").iterator();

        tmp2 = ie1.next().text();

        int idx = tmp2.indexOf(",");
        weather = tmp2.substring(0, idx);

        System.out.println(weather);

        WV.add(new WeatherVO(gu, temperature+"℃", weather));
    }
}
