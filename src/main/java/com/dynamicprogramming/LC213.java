package com.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC213 {

    public static void main(String[] args) {
       int[] nums = {2,3,2};
       LC213 robber = new LC213();
       int x = robber.rob(nums);
        System.out.println(x);
    }

    public int rob(int[] nums) {
      List<Integer> lst = Arrays.stream(nums)
              .boxed()
              .collect(Collectors.toList());
      int dp1[] = new int[nums.length-1];
      int dp2[] = new int[nums.length-1];
      Arrays.fill(dp1,-1);
      Arrays.fill(dp2,-1);
      int maxWithoutFirst = findMax(lst.subList(1,lst.size()), lst.size()-2, dp1);
      int maxWithoutLast = findMax(lst.subList(0, lst.size()-1), lst.size()-2, dp2);
      return Math.max(maxWithoutLast,maxWithoutFirst);
    }

    private int findMax(List<Integer> integers, int n, int[] dp) {
        if(n<0){
            return 0;
        }
        if(n==0){
            dp[0]=integers.get(0);
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int pick =  integers.get(n)+ findMax(integers, n-2, dp);
        int notPick = findMax(integers,n-1,dp);
        dp[n]=Integer.max(pick,notPick);
        return dp[n];
    }
}
