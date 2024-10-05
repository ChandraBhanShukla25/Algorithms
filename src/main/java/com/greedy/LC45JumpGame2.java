package com.greedy;

public class LC45JumpGame2 {

    public static void main(String[] args) {
       int[] nums = {2,3,1,1,4};
       int noOfJumps = jump(nums);
       System.out.println(noOfJumps);
    }

    public static int jump(int[] nums) {
        int currentFar=0;
        int currentEnd=0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            currentFar = Math.max(currentFar, currentFar+nums[i]);
            if(currentEnd==i){
                currentEnd=currentFar;
                count++;
            }
        }
        return count;
    }

}
