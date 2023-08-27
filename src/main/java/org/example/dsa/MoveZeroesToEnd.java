package org.example.dsa;

import java.util.Arrays;

public class MoveZeroesToEnd {
    private static void moveZeros(int[] nums){
        int count = 0;
        for(int num : nums){
            if(num != 0){
                nums[count++] = num;
            }
        }
        while(count < nums.length){
            nums[count++] = 0;
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,5,0,9,8};
        moveZeros(nums);
        Arrays.stream(nums).asLongStream().forEach(System.out::println);

    }
}
