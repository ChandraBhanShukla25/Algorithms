package com.revision.dp;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {
        int arr[] = {16,0,8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7 ,15};
        int x = longestIncreasingSubsequence(arr);
        System.out.println(x);
        int y = countlongestIncreasingSubsequence(arr);
        System.out.println(y);
    }

    public static int longestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(arr[i]>arr[j] && dp[i]<=dp[j]+1){
                    dp[i]=dp[j]+1;
                }else{
                    dp[i]=dp[j];
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static int countlongestIncreasingSubsequence(int arr[]) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int count =1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<=i;j++){
                if(arr[i]>arr[j] && dp[i]<=dp[j]+1){
                    dp[i]=dp[j]+1;
                }else if(arr[i]<arr[j]){
                    count++;
                    dp[i]=dp[j];
                }else{
                    dp[i]=dp[j];
                }
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
        return count;
    }

}
