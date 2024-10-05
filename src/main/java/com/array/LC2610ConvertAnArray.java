package com.array;

import java.util.*;

public class LC2610ConvertAnArray {

    public static void main(String[] args) {
        int nums[] = {1,3,4,1,2,3,1};
        LC2610ConvertAnArray convertAnArray = new LC2610ConvertAnArray();
        List<List<Integer>> lst = convertAnArray.findMatrix(nums);
        System.out.println(lst);
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }

        Set<Integer> set = map.keySet();
        List<List<Integer>> lst = new ArrayList<>();
        while(!map.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i : set) {
                list.add(i);
            }
            lst.add(list);

            for(int i:list){
                map.put(i,map.get(i)-1);
                if(map.get(i)==0){
                    map.remove(i);
                }
            }

        }

        return lst;
    }
}
