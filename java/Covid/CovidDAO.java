package Covid;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

public class CovidDAO {
    static void CoronaDAO(ArrayList<CovidVO> CV) {
        String url = "https://www.busan.go.kr/covid19/Prevention06.do";
        Document doc = null;
        Elements tmp;
        String gu = "";
        Timestamp time = null;
        String num = null;
        int index = 0;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Elements element = doc.select("div.covid-state-table").select("tbody > tr:nth-child(1) > td:nth-child(6)");
        Elements element = doc.select("div.covid-state-table");

        System.out.println("== == == == == == == ==");
        Iterator<Element> ie1 = element.select("tbody > tr:nth-child(1) > td:nth-child(6)").iterator();

        System.out.println(ie1.next().text());
        num = ie1.next().text();

        System.out.println("== == == == == == == ==");

        if (num.equals("-"))
            num = "0";

        System.out.println("출력~" + num);
        CV.add(new CovidVO(gu, num));
    }
}
