package org.com.hermopolis;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Download {
    public static final HttpClient httpClient = HttpClient.newBuilder().build();


    public static void main(String[] args) throws IOException {


        List<String> homePage = getPageUrlList("https://wallhaven.cc/toplist?page=1");
        homePage.stream().map(a -> getUrlList(a)).forEach(a -> System.out.println(a));
        // getUrlList("https://wallhaven.cc/w/7p929e");

    }

    public static void download(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(url))
                    .build();
            HttpResponse.BodyHandler<T> responseBodyHandler
            httpClient.send(request, HttpResponse.BodyHandler < T > responseBodyHandler)
        } catch (Exception e) {
        }


    }

    public void down(String url) throws IOException {
        try (){

        }

        // 打开连接
        URLConnection con = url.openConnection();
        // 输入流
        InputStream is = con.getInputStream();
        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        String filename = "D:\\图片下载/" + i + ".jpg";  //下载路径及下载图片名称
        File file = new File(filename);
        FileOutputStream os = new FileOutputStream(file, true);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        System.out.println(i);
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

    public static List<String> getPageUrlList(String url) {
        try {

            Document document = Jsoup.parse(new URL(url), 5000);
            Elements aTagElements = document.getElementsByTag("a");
            return aTagElements.stream().map(a -> a.getElementsByAttribute("href"))
                    .map(a -> a.attr("href"))
                    .filter(Objects::nonNull)
                    .filter(a -> a.startsWith("https://wallhaven.cc/w/"))
                    .collect(Collectors.toList());
        } catch (Exception e) {

        }
        return Collections.emptyList();
    }

    public static String getUrlList(String url) {
        try {
            Document document = Jsoup.parse(new URL(url), 5000);
            return document.getElementById("wallpaper").attr("src");
        } catch (Exception e) {

        }

        return null;
    }


}
