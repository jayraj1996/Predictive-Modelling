package com.cbu527.predictivemodelling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;


public class WebCrawler {
    private HashSet<String> links;
    //public int maximumCapacityToShowLink = 3;

    public WebCrawler() {
        links = new HashSet<String>();
    }

    public void getWebPageLinks(String url) {

        if (!links.contains(url)) {
            try {
                //4. (i) If not add it to the index
                if (links.add(url)) {
                    System.out.println(url);
                }

                //2. Fetch the HTML code
                Document document = Jsoup.connect(url).get();
                //3. Parse the HTML to extract links to other URLs
                Elements linksOnPage = document.select("a[href]");

                //5. For each extracted URL... go back to Step 4.
                for (Element page : linksOnPage) {
                    getWebPageLinks(page.attr("abs:href"));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
