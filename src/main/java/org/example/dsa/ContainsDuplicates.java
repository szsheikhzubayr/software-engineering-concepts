package org.example.dsa;

import java.util.*;

public class ContainsDuplicates {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4,1,2,3,4}));
    }

    private static boolean containsDuplicate(int[] nums){
        Map<Integer, Integer> fMap = new HashMap<>();
        for(int num : nums){
            fMap.put(num, fMap.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : fMap.entrySet()){
            if(entry.getValue() > 1)
                return true;
        }
        return false;
    }
}
