package com.array;

public class LC896 {

    public static void main(String[] args) {
      int[] nums = {3};
      boolean monotonic = isMonotonic(nums);
        System.out.println(monotonic);
    }

    public static boolean isMonotonic(int[] nums) {
        if(nums.length<=1) return true;
        boolean increasing = false;
        boolean decreasing = false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]) increasing = true;
            if(nums[i]<nums[i-1]) decreasing = true;
            if(increasing && decreasing) return false;
        }

        return true;
    }
}
