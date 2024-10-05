package com.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergeArr = merge(arr);
        for(int i=0;i<mergeArr.length;i++){
            for(int j=0;j<mergeArr[i].length;j++){
                System.out.print(mergeArr[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> lst = new ArrayList<>();
        lst.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(lst.get(lst.size()-1)[1]<=intervals[i][0]){
                lst.add(intervals[i]);
            }else if(lst.get(lst.size()-1)[1]>intervals[i][0]){
                lst.get(lst.size()-1)[1] = Integer.max(intervals[i][1],lst.get(lst.size()-1)[1]);
            }
        }
        int[][] result = new int[lst.size()][2];
        for(int i=0;i< lst.size();i++){
            result[i]=lst.get(i);
        }
        return result;
    }
}
