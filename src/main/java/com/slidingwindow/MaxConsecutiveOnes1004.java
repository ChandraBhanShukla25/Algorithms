package com.slidingwindow;

public class MaxConsecutiveOnes1004 {


    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        MaxConsecutiveOnes1004 maxConsecutiveOnes1004 = new MaxConsecutiveOnes1004();
        int count = maxConsecutiveOnes1004.longestOnes(nums, k);
        System.out.println(count);
    }

    public int longestOnes(int[] nums, int k) {
        int zerosCount = 0;
        int low = 0;
        int high = 0;
        int maxLength = 0;

        while(high<nums.length){
            if(nums[high]==0){
                zerosCount++;
                while(zerosCount>k && low<nums.length){
                    if(nums[low]==0){
                        zerosCount--;
                    }
                    low++;
                }
                maxLength = Integer.max(maxLength, high-low+1);
            }
            maxLength = Integer.max(maxLength, high-low+1);
            high++;
        }
        return maxLength;
    }
}
