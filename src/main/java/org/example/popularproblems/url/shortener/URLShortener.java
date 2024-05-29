package org.example.popularproblems.url.shortener;

import java.util.Random;

public class URLShortener {
    private static final int NUM_CHARS_SHORT_LINK = 7;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private Random random = new Random();

    public String generateRandomShortUrl(){
        char[] result = new char[NUM_CHARS_SHORT_LINK];
        while (true){
            for (int i = 0; i < NUM_CHARS_SHORT_LINK; i++){
                int randomIdx = random.nextInt(ALPHABET.length() - 1);
                result[i] = ALPHABET.charAt(randomIdx);
            }
            String shortLink = new String(result);

//            if(!DB.checkShortLinkExists(shortLink)){
//                return shortLink;
//            }
            //this process of checking the DB every time if the short link already
            //exists or not will be slower with time as the number of links increase
        }
    }
}
