import com.cbu527.predictivemodelling.WebCrawler;

public class Main {
    public static void main(String[] args) {

        WebCrawler webCrawler = new WebCrawler();
        webCrawler.getWebPageLinks("https://www.amazon.com/NANROBOT-Electric-Lithium-Ion-Battery-Mountain/dp/B07GQT7755/ref=sr_1_1_sspa?ie=UTF8&qid=1539308296&sr=8-1-spons&keywords=bicycle&psc=1");

    }
}
