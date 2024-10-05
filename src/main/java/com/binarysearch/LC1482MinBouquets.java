package com.binarysearch;

import java.util.Arrays;

public class LC1482MinBouquets {

    public static void main(String[] args) {
        //int[] bloomDay = {7,7,7,7,12,7,7};
        int  m = 3; int k = 1;
        int[] bloomDay = {1,10,3,10,2};
        LC1482MinBouquets minBouquets = new LC1482MinBouquets();
        int days = minBouquets.minDays(bloomDay, m, k);
        System.out.println(days);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        if(bloomDay.length==0 || m==0 || k==0){
            return 0;
        }
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int fillBuqots = fillBuoquets(bloomDay, mid, m, k);
            if(fillBuqots==1){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }

        }
        return ans;
    }

    // -1 when more days required
    // 1 when less days  reqired
    //0 when days are optimal
    public int fillBuoquets(int[] bloomDay,int mid, int m, int k){
        int start = 0;
        int count = 0;
        for(int i=0; i<bloomDay.length;i++){
           if(mid/bloomDay[i]>=1){
               start++;
               if(start==k){
                   count++;
                   start=0;
               }
           }else{
               start = 0;
           }
        }
       if(count<m){
           return -1;
       }
       return 1;
    }
}
