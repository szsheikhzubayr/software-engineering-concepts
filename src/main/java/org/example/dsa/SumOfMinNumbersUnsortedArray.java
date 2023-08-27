package org.example.dsa;

public class SumOfMinNumbersUnsortedArray {
    public static int sumOfTwoLowest(int[] nums){
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num < firstMin){
                secondMin = firstMin;
                firstMin = num;
            }else if(num < secondMin){
                secondMin = num;
            }
        }
        return firstMin + secondMin;
    }

    public static void main(String[] args) {
        int[] nums = {4,9,5,3,1};
        System.out.println("Sum of two min numbers: " + sumOfTwoLowest(nums));
    }
}
