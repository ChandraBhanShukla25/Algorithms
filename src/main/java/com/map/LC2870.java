package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LC2870 {
    public static void main(String[] args) {
        int[] nums = {2,3,3,2,2,4,2,3,4};
        int nums1[]= {2,1,2,2,3,3};
        int nums2[] = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        LC2870 lc = new LC2870();
        //int x = lc.minOperations(nums);
        //int x1 = lc.minOperations(nums1);
        int x2 = lc.minOperations(nums2);
        //System.out.println(x);
        //System.out.println(x1);
        System.out.println(x2);
    }

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map  = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Set<Integer> set = map.keySet();
        int count = 0;
        for(int i: set){
            if(map.get(i)%2!=0 && map.get(i)%3!=0){
                return -1;
            }
            int first = 0;
            if(map.get(i)%2==0){
                first = map.get(i)/2;
            }
            if(map.get(i)%3==0){
                first = map.get(i)/3;
            }
            if(map.get(i)%3==1){
                int x= map.get(i);
                int multiplier = 0;
                while(x>=3){
                    x= x-3;
                   multiplier++;
                }
                first= multiplier+ 1;
            }
            count+= first;
        }
        return count;
    }
}
