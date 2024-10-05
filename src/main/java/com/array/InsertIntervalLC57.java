package com.array;

import java.util.*;

public class InsertIntervalLC57 {

    public static void main(String[] args) {
        int[][] intervals =   {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[]  newInterval = {4,8};
        InsertIntervalLC57 intervalLC57 = new InsertIntervalLC57();
        int[][] result =intervalLC57.insert(intervals, newInterval);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
       List<int[]> lst = new ArrayList<>();
       lst.addAll(Arrays.asList(intervals));
       lst.add(newInterval);

       lst.sort((i1,i2) -> i1[0]-i2[0]);
       List<int[]> result = new ArrayList<>();
       result.add(lst.get(0));
       for(int i=1;i<lst.size();i++){
           if(result.get(result.size()-1)[1] > lst.get(i)[1]){
             continue;
           } else if(result.get(result.size()-1)[1] >= lst.get(i)[0]){
               result.get(result.size()-1)[1]=lst.get(i)[1];
           }else{
               result.add(lst.get(i));
           }
       }
        System.out.println(result);
        //return result.stream().map(l->l.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        return result.toArray(int[][]::new);
    }
}


// Case 1: