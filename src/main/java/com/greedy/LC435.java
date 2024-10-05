package com.greedy;

import java.util.Arrays;

public class LC435 {

    public static void main(String[] args) {
      int[][] intervals =  {{1,2},{2,3}};
      int count = eraseOverlapIntervals(intervals);
        System.out.println(count);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int count =1;
        int lastEndTime = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=lastEndTime){
                count++;
                lastEndTime=intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
