package com.revision.string;

import java.util.*;

public class LC347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        LinkedList<Map.Entry<Integer,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        int[] res = new int[k];
        int i =0;
        for(Map.Entry<Integer,Integer> entry: list){
            if(i<k){
                res[i]=entry.getKey();
                i++;
            }
        }
   return res;

    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        int[] arr = topKFrequent(nums, k);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
