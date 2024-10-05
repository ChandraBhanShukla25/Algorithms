package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicates {

    public List<Integer> findDuplicates(int[] nums)  {
       Map<Integer,Integer> duplicateMap = new HashMap<>();
       List<Integer> lst = new ArrayList<>();
       for(int i: nums){
           if(duplicateMap.containsKey(i)){
               duplicateMap.put(i, duplicateMap.get(i)+1);
               lst.add(i);
           }else{
               duplicateMap.put(i, 1);
           }
       }
       return lst;
    }

    public static void main(String[] args) {
        int[] nums  = {4,3,2,7,8,2,3,1};
        FindAllDuplicates findAllDuplicates = new FindAllDuplicates();
        List<Integer> count = findAllDuplicates.findDuplicates(nums);
        System.out.println(count);

    }
}
