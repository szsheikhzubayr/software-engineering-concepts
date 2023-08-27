package org.example.dsa;

import java.util.Stack;

public class ValidPalindrome {
    public static boolean isPalindrome(String s){
        if(s.length() == 0 || s.length() == 1){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                stack.push(Character.toLowerCase(s.charAt(i)));
            }
        }
        for (int i = 0; i < s.length(); i++){
            if(Character.isLetter(s.charAt(i)) && stack.peek() == Character.toLowerCase(s.charAt(i))){
                stack.pop();
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(s + " is palindrome? " + isPalindrome(s));
    }
}
