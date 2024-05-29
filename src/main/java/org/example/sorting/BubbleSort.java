package org.example.sorting;

import java.util.Arrays;

public class BubbleSort {
    /**
     *
     * 4,1,2,3
     *
     */
    public static void doBubbleSort(int[] arr){
        //4,1,2,3
        int n = arr.length;
        for (int i = n-1; i >= 0; i--){
            for (int j= 0; j <= i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            Arrays.stream(arr).forEach(System.out::print);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,3};
        doBubbleSort(arr);
//        Arrays.stream(arr).forEach(System.out::println);
    }
}
