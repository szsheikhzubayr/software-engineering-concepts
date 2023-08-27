package org.example.challenge;

import java.util.*;

public class PingPongMatcher {
    private static List<PlayerInterval> allIntervals = new ArrayList<>();

    static class PlayerInterval implements Comparable<PlayerInterval> {
        int start;
        int end;
        int playerId; // Unique identifier for the player


        PlayerInterval(int start, int end, int playerId) {
            this.start = start;
            this.end = end;
            this.playerId = playerId;
        }

        @Override
        public String toString() {
            return "PlayerInterval{" +
                    "start=" + start +
                    ", end=" + end +
                    ", playerId=" + playerId +
                    '}';
        }

        @Override
        public int compareTo(PlayerInterval o) {
            if(this.start > o.start){
//                allIntervals.forEach(System.out::println);
//                System.out.println("____________________");
                return 1;
            }else if(this.start < o.start){
//                allIntervals.forEach(System.out::println);
//                System.out.println("___________________");
                return -1;
            }else{
//                allIntervals.forEach(System.out::println);
//                System.out.println("__________________");
                return 0;
            }
        }
    }

    public static int[] countGames(List<List<PlayerInterval>> playerTimings) {


        for (List<PlayerInterval> intervals : playerTimings) {
            allIntervals.addAll(intervals);
        }

        Collections.sort(allIntervals);

        int singles = 0, doubles;

        // To store players who are available but not matched yet
        List<PlayerInterval> unmatched = new ArrayList<>();

        for (PlayerInterval current : allIntervals) {
            boolean isMatched = false;

            Iterator<PlayerInterval> iterator = unmatched.iterator();
            while (iterator.hasNext()) {
                PlayerInterval prev = iterator.next();
                if (prev.end > current.start) { // Found a match for singles
                    System.out.println("prev.end " + prev.end + " & current.start " + current.start);
                    unmatched.forEach(System.out::println);
                    singles++;
                    isMatched = true;
                    iterator.remove(); // Remove the matched player
                    break;
                }
            }


            //whosoever is not matched for singles match will be open for doubles
            if (!isMatched) {
                System.out.println("current.start " + current.start);
                unmatched.forEach(System.out::println);
                unmatched.add(current);
                System.out.println("After adding:");
                unmatched.forEach(System.out::println);
            }
        }

        doubles = unmatched.size() / 4; //because 4 players are required for doubles

        return new int[]{singles, doubles};
    }

    public static void main(String[] args) {
        List<List<PlayerInterval>> timings = new ArrayList<>();
        timings.add(Arrays.asList(new PlayerInterval(9, 11, 1), new PlayerInterval(14, 16, 1)));
        timings.add(Arrays.asList(new PlayerInterval(9, 11, 2)));
        timings.add(Arrays.asList(new PlayerInterval(10, 12, 3)));
        timings.add(Arrays.asList(new PlayerInterval(9, 10, 4), new PlayerInterval(15, 17, 4)));
        timings.add(Arrays.asList(new PlayerInterval(13, 15, 5)));

        int[] result = countGames(timings);
        System.out.println("Singles: " + result[0] + ", Doubles: " + result[1]);
    }
}
