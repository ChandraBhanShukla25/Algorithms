package com.greedy;

public class LC55JumpGame {

    public static void main(String[] args) {
       int[] nums = {2,2,1,1,0};
       boolean canJump = canJump(nums);
        System.out.println(canJump);
    }

    public static boolean canJump(int[] nums) {
         int maxJump = 0;

         for(int i=0;i<nums.length;i++){
             if(i>maxJump)
                 return false;
             maxJump = Integer.max(i+nums[i], maxJump);
         }
         return true;
    }
}
