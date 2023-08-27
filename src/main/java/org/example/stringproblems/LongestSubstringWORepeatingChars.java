package org.example.stringproblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWORepeatingChars {
    private static int findLongestSubstringWORepeatingChars(String input){
        Map<Character,Integer> fMap = new HashMap<>();
        int i = -1, j = -1,ans = 0;
        while (true) {

            boolean f1 = false, f2 = false;

            //aquire until you become invalid
            while(i < input.length() - 1){
                f1 = true;
                i++;
                char c = input.charAt(i);
                fMap.put(c, fMap.getOrDefault(c, 0) + 1);
                if(fMap.get(c) == 2){
                    break;
                }else{
                    int len = i - j;
                    ans = Math.max(len, ans);
                }
            }

            //release until you become valid
            while(j < i){
                f2 = true;
                j++;
                char ch  = input.charAt(j);
                fMap.put(ch, fMap.get(ch) - 1);

                if(fMap.get(ch) == 1){
                    break;
                }

            }
            if(f1 == false && f2 == false){
                break;
            }

        }

        return ans;

    }
    public static void main(String[] args) {

        String input = "abcabcbb";
        System.out.println(findLongestSubstringWORepeatingChars(input));

    }
}
