package org.example.searching;

public class BinarySearch {
    public static boolean binarySearchRecursively(int left, int right, int[] arr, int x){
        if(left > right)
            return false;
        int mid = (left + right)/2;
        if(arr[mid] == x){
            return true;
        }else if(x < arr[mid]){
            return binarySearchRecursively(left, mid -1, arr, x);
        }else{
            return binarySearchRecursively(mid + 1, right, arr,x);
        }
    }

    public static boolean binarySearchIterative(int[] arr, int x){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + ((right - left)/2);
            if(arr[mid] == x){
                return true;
            }else if(x < arr[mid]){
                right = mid - 1;
            }else{
                left = mid  + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("binarySearchRecursively: " + binarySearchRecursively(0,3,new int[]{1,2,3,4}, 4));
        System.out.println("binarySearchIterative: " + binarySearchIterative(new int[]{1,2,3,4},3));
    }
}
