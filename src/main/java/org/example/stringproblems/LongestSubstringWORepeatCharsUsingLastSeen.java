package org.example.stringproblems;

import java.util.*;

public class LongestSubstringWORepeatCharsUsingLastSeen {
    private static int findLongestSubstringWORepeatingChars(String input){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int n = input.length();
        int len = 0;
        while(right < n){
            if(map.containsKey(input.charAt(right)))
                //we check in the map if the current char exists, if it does then we move left one place ahead of the last seen idx of the char
                //this will ensure that the substring(from left after moving -> current right) will not have any duplicates
                left = Math.max(map.get(input.charAt(right)) + 1, left);
            //update the map with the current last seen value of the char
            map.put(input.charAt(right), right);
            //update the length of the longest substring if the length of the current substring is greater than the previous one
            len = Math.max(len, right - left + 1);
            //move towards the right of the string
            right++;
        }

        return len;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstringWORepeatingChars("pwwkew"));
    }

}
