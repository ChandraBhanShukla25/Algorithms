package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class LC120TrianglePathSum {

    public static void main(String[] args) {
        int[][] triangle = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> list = new ArrayList<>();
        for(int[] arr: triangle){
            List<Integer> lst = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                lst.add(arr[0]);
            }
            list.add(lst);
        }
        LC120TrianglePathSum lc120 = new LC120TrianglePathSum();
        int val = lc120.minimumTotal(list);
        System.out.println(val);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return getMinimumTotal(triangle, 0, 0);
    }
    private int getMinimumTotal(List<List<Integer>> triangle, int i, int j) {
        if(i<0 || j<0){
            return 1000000;
        }
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }

            int up = triangle.get(i).get(j) + getMinimumTotal(triangle, i +1, j);
            int diagonal = triangle.get(i).get(j) + getMinimumTotal(triangle, i + 1, j +1);
            return Math.min(up,diagonal);

    }
}
