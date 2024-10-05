package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC452Mergeballons {

    public static void main(String[] args) {
        int[][] arr = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};

        LC452Mergeballons mergeballons = new LC452Mergeballons();
        int x = mergeballons.findMinArrowShots(arr);
        System.out.println(x);

    }
    // 1,6  2,8   7 12   10 16
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a->a[1]));
        List<int[]> resultList = new ArrayList<>();
        int count =1;
        int end = points[0][1];
        for(int i=1;i<points.length;i++){
            if(end>= points[i][0]){
                continue;
            }else{
                end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
