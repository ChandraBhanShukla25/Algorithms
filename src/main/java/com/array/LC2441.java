package com.array;

import java.util.HashSet;
import java.util.Set;

public class LC2441 {

    public static void main(String[] args) {
        LC2441 lc2441 = new LC2441();
        int[] nums= {-1,2,-3,3};
        int x = lc2441.findMaxK(nums);
        System.out.println(x);
    }

    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max =-1;
        for(int i=0;i<nums.length;i++){
            int x= -1 * nums[i];
            if(set.contains(x)){
                if(Math.abs(nums[i])>max){
                    max=Math.abs(nums[i]);
                }
            }
            set.add(nums[i]);
        }
        return max;
    }
}
