package org.example.stringdiscovery;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringDiscovery {

    private static String stream = "aiaiirtelrtelartel";
    private static String target = "airtel";
    private static List<Character> targetCharList = target.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
    private static Map<Character, Integer> charMap = new HashMap<>();


    static int discoverString(Character c, String target){


        //get updated freq of char from charMap
        int updatedFrequency = 0;
        int currFrequency = 0;


        if(charMap.containsKey(c)){
            currFrequency = charMap.get(c);
            updatedFrequency = currFrequency + 1;

        }

        //get the preceding char, check the frequency of preceding char
        int currCharIdx = targetCharList.indexOf(c);
        char precedingChar = ' ';
        if(currCharIdx > 0)
            precedingChar = targetCharList.get(currCharIdx - 1);

        //check frequency of preceding char in charMap
        int precedingCharFrequency = charMap.getOrDefault(precedingChar, 0);

        //if updatedFrequency > freq of preceding char -> ignore this char and not update the map
        if(updatedFrequency <= precedingCharFrequency && updatedFrequency != 0)  //first char updatedFrequency =  1, precedingCharFrequency = 0
            charMap.put(c, charMap.getOrDefault(c, 1) + 1);

        //get the minimum frequency among all the char
        int minFrequency = Collections.min(charMap.values());

        boolean canFormTargetString = false;

        //check if all the char frequencies are atleast 1, if true, then we can form as many target strings as minFrequency
        for(Map.Entry<Character, Integer> entry : charMap.entrySet()){
            if(entry.getValue() >= 1)
                canFormTargetString = true;
            else
                canFormTargetString = false;

        }

        return canFormTargetString ? minFrequency : 0;
    }
    public static void main(String[] args) {

        for (int i = 0; i < stream.length(); i++) {
            discoverString(stream.charAt(i), target);
        }


    }
}
