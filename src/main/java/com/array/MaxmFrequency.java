package com.array;

import java.util.HashMap;
import java.util.Map;

public class MaxmFrequency {

    public static void main(String[] args) {
        int arr[]= {1,2,2,3,1,4};
        maxmFrequnecy(arr);
    }

    private static int maxmFrequnecy(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (int j : arr) {
            if (map.containsKey(j)) {
                maxFrequency = Integer.max(maxFrequency, map.get(j) + 1);
                map.put(j, map.get(j) + 1);
            } else {
                maxFrequency = Integer.max(maxFrequency,1);
                map.put(j, 1);
            }
        }
        int count = 0;
        for(Integer key: map.keySet()){
            if(map.get(key)==maxFrequency){
                count+=maxFrequency;
            }
        }

        return count;
    }
}
