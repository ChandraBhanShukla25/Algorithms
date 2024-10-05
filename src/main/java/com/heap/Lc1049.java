package com.heap;

import java.util.Arrays;

public class Lc1049 {

    public static void main(String[] args) {
       int[] stones= {31,26,33,21,40};
       int x = lastStoneWeightII(stones);
        System.out.println(x);
    }

    public static int lastStoneWeightII(int[] stones) {
       int sum = Arrays.stream(stones).sum();
       int target = sum / 2;
       boolean[] dp = new boolean[target+1];
      dp[0]=true;
       for(int stone: stones){
           for(int j=target;j>=stone;j--){
               dp[j]=dp[j]||dp[j-stone];
           }
       }

       for(int j=target;j>=0;j--){
           if(dp[j]){
               return sum-2*j;
           }
       }
       return 0;
    }

}
