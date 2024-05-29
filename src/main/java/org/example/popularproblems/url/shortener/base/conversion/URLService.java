package org.example.popularproblems.url.shortener.base.conversion;

import java.net.URL;
import java.util.HashMap;

public class URLService {
    HashMap<String, Integer> ltos;
    HashMap<Integer, String> stol;

    static int COUNTER;

    String elements;

    URLService(){
        ltos = new HashMap<>();
        stol = new HashMap<>();
        COUNTER = 1000000000;
        elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public String longToShort(String url){
        String shortUrl = base10tobase62(COUNTER);
        ltos.put(url, COUNTER);
        stol.put(COUNTER, url);
        COUNTER++;
        return "http://tiny.url/" + shortUrl;
    }

    public String shortToLong(String url){
        url = url.substring("http://tiny.url/".length());
        int n = base62tobase10(url);
        return stol.get(n);
    }

    public int base62tobase10(String s){
        int n = 0;
        for (int i = 0; i < s.length(); i++){
            n = n * 62 + convert(s.charAt(i));
        }
        return n;
    }

    public int convert(char c){
        if(c >= '0' && c <= '9')
            return c - '0';
        if (c >= 'a' && c <= 'z')
            return c - 'a' + 10;
        if (c >= 'A' && c <= 'Z')
            return c - 'A' + 36;
        return -1;
    }


    public String base10tobase62(int n){
        StringBuilder sb = new StringBuilder();
        while (n != 0){
            sb.insert(0, elements.charAt(n%62));
            n /= 62;
        }
        while(sb.length() != 7){
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        URLService urlService = new URLService();
        System.out.println(urlService.longToShort("https://medium.com/@sandeep4.verma/system-design-scalable-url-shortener-service-like-tinyurl-106f30f23a82"));
        System.out.println(urlService.shortToLong("http://tiny.url/015FTGg"));
    }

}
