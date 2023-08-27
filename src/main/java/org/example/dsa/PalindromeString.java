package org.example.dsa;

import java.util.Stack;

public class PalindromeString {
    private static boolean isStringPalindrome(String input){
        input = input.toLowerCase();
        for(int i = 0; i < input.length()/2; i++){
            if(input.charAt(i)!=input.charAt(input.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println(isStringPalindrome("KAyak"));

    }
}
