package com.binarysearch;

import java.util.ArrayList;

public class PaintersPartition {

    public static void main(String[] args) {
       int N = 4;
       int[] board = {5, 5, 5, 5};
       ArrayList<Integer> al = new ArrayList<>();

       for(int i: board){
           al.add(i);
       }
       int k = 2;
       int result = findLargestMinDistance(al, k);
        System.out.println(result);
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        if(boards.size()==0 || k==0){
            return 0;
        }
        int low = boards.stream().mapToInt(Integer::intValue).max().getAsInt();
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while(low<=high){
            int mid = (low+high)/2;
            int minDistance = calculateMinDistance(boards, mid);
            if(k<minDistance){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    private static int calculateMinDistance(ArrayList<Integer> boards, int mid) {
        int partitions = 1;
        int partitionsSum = 0;

        for(int i=0;i<boards.size();i++){
            if(partitionsSum+boards.get(i)<=mid){
                partitionsSum+=boards.get(i);
            }else{
                partitions++;
                partitionsSum=boards.get(i);
            }
        }
        return partitions;
    }
}
