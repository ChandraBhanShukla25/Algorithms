package com.bitwise;

import java.util.Arrays;

public class Lc1310 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,8}; int [][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int[] xorResult = xorQueries(arr, queries);
        Arrays.stream(xorResult).forEach(System.out::println);
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length; i++){
            int xor=0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                xor ^= arr[j];
            }
            result[i]=xor;
        }
        return result;
    }
}
