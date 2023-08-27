package org.example.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MeetupSchedule {


    public static int maxEvents(int[][] events) {

        //1. Sort events array by end date and if they are equal then by start date
        Arrays.sort(events, (a, b) -> {
            if (a[1] > b[1]) {
                return 1; // basically return true only when either end dates are not equal to sort by end date
            } else if (a[1] == b[1]) {
                if (a[0] > b[0]) {
                    return 1; //or return if start dates are not equal to sort by start date
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        });

        // initilization of vars
        int counter = 0;
        int start = 0;
        int end = 1;


        // 2. find the max time and min time to fill the set
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int row = 0; row < events.length; row++) {
            max = max > events[row][end] ? max : events[row][end];
            min = min < events[row][start] ? min : events[row][start];
        }
        System.out.println("max: " + max + " min: " + min);

        // 3. create set and fill it with false values, that signifies the days of the event which have not been visited. If false then it is visited
        //basically creating a an array with all false values as nothing has been visited so far.
        boolean[] set = new boolean[max-min+1];
        for (int i = min; i <= max; i++) {
            System.out.println("Setting false for: " + i);
            set[i-min] = false;
        }

        // 4. iterate the events and apply greedy approach to get the earliest start date possible if not then iterate till end date to get the day visited.
        for (int row = 0; row < events.length; row++) {
            for (int val = events[row][start]; val <= events[row][end]; val++) {
                // if day not visited then mark as visited and count it
                if (!set[val-min]) {
                    counter++;
                    set[val-min] = true;
                    break;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[][] events = {{1,2},{1,2},{3,3},{1,5},{1,5}};
        System.out.println(maxEvents(events));
    }
}


