package com.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinct992 {
//unsolved
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        SubArrayWithKDistinct992 subArrayWithKDistinct992 = new SubArrayWithKDistinct992();
        int x = subArrayWithKDistinct992.subarraysWithKDistinct(nums, k);
        System.out.println(x);
    }


    public int subarraysWithKDistinct(int[] nums, int k) {
       return  atMostKDisticnt(nums, k)-atMostKDisticnt(nums, k-1);
    }

    public int atMostKDisticnt(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int high = 0;
        int low = 0;
        int count = 0;

        while(high<nums.length){
            map.merge(nums[high], 1, Integer::sum);

            while(map.size()>k){
                map.merge(nums[low], -1, Integer::sum);
                if(map.get(nums[low])==0){
                    map.remove(nums[low]);
                }
                low++;
            }
            count+=high-low+1;
            high++;
        }
        return count;
    }
}
