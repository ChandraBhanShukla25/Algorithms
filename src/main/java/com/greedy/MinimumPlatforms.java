package com.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int count = MinimumPlatforms.findPlatform(arr, dep, arr.length);
        System.out.println(count);
    }
    static int findPlatform(int[] arr, int[] dep, int n) {
         int minDeparture = Integer.MAX_VALUE;
         int countOfPlatform = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

         for(int i=0;i<arr.length;i++){
            if(priorityQueue.isEmpty() || priorityQueue.peek()>arr[i]){
                countOfPlatform++;
            }else{
                priorityQueue.poll();
            }
            priorityQueue.add(dep[i]);
         }
         return countOfPlatform;
    }
}
