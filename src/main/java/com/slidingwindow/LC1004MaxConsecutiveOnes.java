package com.slidingwindow;

public class LC1004MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int x= new LC1004MaxConsecutiveOnes().longestOnes(nums, k);
        System.out.println(x);

    }
    public int longestOnes(int[] nums, int k) {

        int maxLength = 0;
        int j=0;
        int zeros = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeros++;
            }
            while(zeros>k){
               if(nums[j]==0){
                   zeros--;
               }
               j++;
            }
            maxLength= Integer.max(maxLength,i-j+1);
        }
      return maxLength;
    }

}
