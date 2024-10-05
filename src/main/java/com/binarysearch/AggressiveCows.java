package com.binarysearch;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
      int N = 6; int  k = 4; int[] arr = {0,3,4,7,10,9};
      AggressiveCows aggressiveCows = new AggressiveCows();
      int aggressiveCowsMinDistance = aggressiveCows.minDistance(arr, N, k);
      int aggressiveCowDistanceUsingBinarySearch = aggressiveCows.minDistanceUsingBinarySearch(arr, N, k);

        System.out.println(aggressiveCowsMinDistance);
        System.out.println(aggressiveCowDistanceUsingBinarySearch);
    }

    public int minDistance(int[] stalls, int n, int k){
        Arrays.sort(stalls);
        int min = stalls[0];
        int max = stalls[n-1];

        for(int i=1;i<=max-min;i++){
            if(!canWePlace(stalls, i, k)){
                return i-1;
            }
        }
        return 0;
    }

    private boolean canWePlace(int[] stalls, int minDist, int k) {
        int last = stalls[0];
        int cowsPlaced= 1;
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last>=minDist){
                last = stalls[i];
                cowsPlaced++;
            }
            if(cowsPlaced==k){
                return true;
            }
        }
        return false;
    }

    public int minDistanceUsingBinarySearch(int[] stalls, int n, int k){
        int low = stalls[0];
        int high = stalls[n-1];

        while(low<=high){
            int mid = (low+high)/2;
            if(canWePlace(stalls,mid, k)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return high;
    }


}
