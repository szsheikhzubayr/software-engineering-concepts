package org.example;

import java.util.*;

public class MapUtil {
    /**
     * Given a map, split it by processor count on the machine.
     *
     * @param <K> An object that is immutable
     * @param <V> Object referred by the key in the map.
     * @param map The bulky map with mutually exclusive data with K as key and V as
     *            Value
     * @return A list of Map objects that can be processed by separate processors
     */
    public static <K, V> List<Map<K, V>> splitMapByProcessor(Map<K, V> map) {
        Runtime runtime = Runtime.getRuntime();
        int procCount = runtime.availableProcessors();
        System.out.println("Processors : " + procCount);

        List<Map<K, V>> splittedMaps = new ArrayList<>();

        // TODO implement the splitter
        int mapSize = map.size();
        int valuesPerProcessor = mapSize / procCount + mapSize % procCount;
        System.out.println("valuesPerProcessor: " + valuesPerProcessor);

        Map<K,V> subMap = new HashMap<>();

        int counter = valuesPerProcessor;
        for(Map.Entry<K,V> entry : map.entrySet()){
            if(counter > 0){
                subMap.put(entry.getKey(), entry.getValue());
                counter--;
            }else{
                subMap.put(entry.getKey(), entry.getValue());
                splittedMaps.add(subMap);
                counter = valuesPerProcessor;
                subMap = new HashMap<>();
            }
        }
        splittedMaps.add(subMap);


        return splittedMaps;
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        populateMap(map);
        List<Map<Integer, List<Integer>>> splitMapList = splitMapByProcessor(map);
        System.out.println("total number of maps: " + splitMapList.size());

        int mapCnt = 0;

        for (Map<Integer, List<Integer>> subMap : splitMapList) {
            System.out.println("Contents of Map: " + ++mapCnt);
            System.out.println("Size : " + subMap.size());

            for (int k : subMap.keySet()) {
                System.out.println(k + "-> " + subMap.get(k));
            }
            System.out.println("--------------");
        }
    }
    private static void populateMap(Map<Integer, List<Integer>> map) {

        for (int i = 1; i <= 63; i++) {
            map.put(i, Arrays.asList(i));
        }
    }
}
