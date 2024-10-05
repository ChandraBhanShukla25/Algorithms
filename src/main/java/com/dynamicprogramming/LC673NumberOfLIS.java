package com.dynamicprogramming;

import java.util.Arrays;

public class LC673NumberOfLIS {

    public static void main(String[] args) {
       int[] nums = {1,3,5,4,7};
       LC673NumberOfLIS numberOfLIS = new LC673NumberOfLIS();
       int x = numberOfLIS.findNumberOfLIS(nums);
       System.out.println(x);
    }

    public int findNumberOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
       int[] cnt = new int[nums.length];

        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    cnt[i]= cnt[j];
                }else if(nums[i]>nums[j] && dp[i]==dp[j+1]){
                    cnt[i]=cnt[j]+1;
                }
            }
        }

        int noOfSubsequnece = 0;
        for(int i=0;i<cnt.length;i++){
            noOfSubsequnece = Integer.max(noOfSubsequnece,cnt[i]);
        }
        return noOfSubsequnece;
    }
}
