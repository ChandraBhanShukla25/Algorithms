package com.practice.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPathSumInATriangularGrid {

    public static void main(String[] args) {
        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(Arrays.asList(2));
        lst.add(Arrays.asList(3,4));
        lst.add(Arrays.asList(6,5,7));
        lst.add(Arrays.asList(4,1,8,3));

        int x= minimumTotal(lst);
        System.out.println(x);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        int m = 0;
        int n =0;
        return findMinTotal(triangle,dp, m, n);
    }

    private static int findMinTotal(List<List<Integer>> triangle, int[][] dp, int m, int n) {
        if(m==triangle.size()-1){
            int max = Integer.MAX_VALUE;
            int len = triangle.get(m).size()-1;
            for(int i=0;i<len;i++){
               max = Integer.min(triangle.get(m).get(i), max);
            }
           return dp[m][n]=max;
        }
        int down = Integer.MAX_VALUE;
        int side = Integer.MAX_VALUE;
        if(m+1<triangle.size()){
           down = triangle.get(m).get(n)+ findMinTotal(triangle,dp, m+1,n);
        }
        if(m+1<triangle.size() && n+1<triangle.get(m+1).size() && n>=0) {
            side = triangle.get(m).get(n) + findMinTotal(triangle, dp, m + 1, n + 1);
        }

        return dp[m][n]=Integer.min(down,side);
    }
}
