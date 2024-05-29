package org.example.popularproblems.url.shortener.base.conversion;

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

}
