package com.slidingwindow;

public class LC1248NiceSubarrays {

    public static void main(String[] args) {
       int[] nums = {2,2,2,1,2,2,1,2,2,2};
       int k = 2;
       LC1248NiceSubarrays niceSubarrays = new LC1248NiceSubarrays();
       int count = niceSubarrays.numberOfSubarrays(nums, k);
       System.out.println(count);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int count = subArraysWithKOdd(nums, k)-subArraysWithKOdd(nums, k-1);
        return count;
    }

    public int subArraysWithKOdd(int[] nums, int k){
        int sum = 0;
        int count = 0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]%2;
            while(sum>k){
                sum-=(nums[j]%2);
                j++;
            }
            count+=i-j+1;
        }
        return count;
    }

}
