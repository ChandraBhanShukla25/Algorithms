package com.array.important;

import javax.swing.plaf.IconUIResource;

public class CountSubarraysWithsum {

    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 3;
        CountSubarraysWithsum subarraysWithsum = new CountSubarraysWithsum();
        int count = subarraysWithsum.subarraySum(nums, k);
        System.out.println(count);
    }

    public int subarraySum(int[] nums, int k) {
        int i=0;
        int j=0;
        int n = nums.length;
        int sum = 0;
        int count=0;

        while(i<n){
            sum+=nums[i];
            while(sum>k && j<i){
                sum-=nums[j];
                j++;
            }
            if(sum<0 && j<i){
                sum=0;
            }
            if(sum==k){
                count++;
            }
            i++;
        }
        return count;
    }
}
