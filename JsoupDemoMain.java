import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by ScorpionOrange on 2017/01/15.
 */
public class JsoupDemoMain {
    public static void main(String[] args) throws IOException {
        //System.out.println("Testing");
        String url = "https://www.oschina.net/news";

        Document document = Jsoup.connect(url).get();
        /*
         * Document document = Jsoup.connect(url)
         *        .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:30.0) Gecko/20100101 Firefox/30.0")
         *        .get();
         */

        Elements elements = document.select("#all-news");

        for (Element element : elements) {
            Elements titleElement = element.select("a[href]").select("class");
            String title = titleElement.text();
            String link = titleElement.attr("href").trim();

            Elements dataElement = element.select(".date");
            Elements authorElement = dataElement.select("a");
            String author = authorElement.text();
            authorElement.remove();
            String date = dataElement.text();
            String detail = element.select(".detail").text();

            System.out.println("链接：        " + "http://www.oschina.net"+link);
            System.out.println("标题：        " + title);
            System.out.println("作者：        " + author);
            System.out.println("发布时间： " + date);
            System.out.println("详细信息： " + detail);
            System.out.println();
            System.out.println();
        }

        System.out.println(elements.size());
    }
}
