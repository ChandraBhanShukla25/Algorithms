package com.recursion;

import java.util.Arrays;

public class LC1498DP {

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 6, 7};
        int target = 12;
        LC1498DP lc1498DP = new LC1498DP();
        int x = lc1498DP.numSubseq(arr, target);
        System.out.println(x);
    }

    public int numSubseq(int[] nums, int target) {
        int[] dp = new int[nums.length + 1];

        for (int i = 1; i < nums.length - 1; i++) {
            int sum = nums[i];
            for (int j = 0; j < i; j++) {
                if (sum + nums[j] <= target && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        return Arrays.stream(dp).max().getAsInt();

    }
}
