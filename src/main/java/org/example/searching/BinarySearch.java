package org.example.searching;

public class BinarySearch {
    private static int findElement(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left<=right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int target = 1;
        System.out.println(findElement(nums,target));
    }
}
