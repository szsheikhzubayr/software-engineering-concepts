package org.example.popularproblems.url.shortener.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;

public class MD5UrlShortener {
    private static int SHORT_URL_CHAR_SIZE=7;
    public static String convert(String longUrl){
        try {
            //create md5 hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(longUrl.getBytes());
            byte messageDigest[] = digest.digest();

            //create hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest){
                hexString.append(Integer.toHexString(0xFF & b));
            }
            System.out.println(hexString);
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateRandomShortUrl(String longUrl){
        HashSet<String> shortUrlSet = new HashSet<>();
        String hash = MD5UrlShortener.convert(longUrl);
        int numberOfCharsInHash = hash.length();
        int counter = 0;
        while (counter < numberOfCharsInHash-SHORT_URL_CHAR_SIZE){
            if(!shortUrlSet.contains(hash.substring(counter, counter + SHORT_URL_CHAR_SIZE))){
                shortUrlSet.add(hash.substring(counter, counter + SHORT_URL_CHAR_SIZE));
                return "http://tiny.url/" + hash.substring(counter, counter+SHORT_URL_CHAR_SIZE);
            }
            counter++;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(generateRandomShortUrl("https://medium.com/@sandeep4.verma/system-design-scalable-url-shortener-service-like-tinyurl-106f30f23a82"));
    }
}
