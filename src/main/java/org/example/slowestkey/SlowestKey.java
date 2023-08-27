package org.example.slowestkey;

import java.util.TreeMap;

public class SlowestKey {
    public static char slowestKey(int[] releaseTimes, String keysPressed) {

        TreeMap<Integer, Character> pressTimes = new TreeMap<>();

        for(int i = 0; i < releaseTimes.length - 1; i++){
            int pressTime = releaseTimes[i+1] - releaseTimes[i];
            Character currChar = keysPressed.charAt(i);
            Character mapChar = pressTimes.getOrDefault(pressTime, 'a');
            Character maxChar = currChar > mapChar ? currChar : mapChar;
            pressTimes.put(pressTime, maxChar);
        }

        return pressTimes.get(pressTimes.lastKey());

    }

    public static void main(String[] args) {
        int[] releaseTimes = new int[]{9, 29, 49, 50};
        String keysPressed = "cbcd";
        System.out.println(slowestKey(releaseTimes,keysPressed));
    }

}
