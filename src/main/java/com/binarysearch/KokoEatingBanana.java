package com.binarysearch;

import java.util.Arrays;

public class KokoEatingBanana {

    public static void main(String[] args) {
      int[] piles = {3,6,7,11}; int h = 8;
        KokoEatingBanana kokoEatingBanana = new KokoEatingBanana();
        int speed = kokoEatingBanana.minEatingSpeed(piles, h);
        System.out.println(speed);
    }
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length==0 || h==0){
            return 0;
        }
        int max= Arrays.stream(piles).max().getAsInt();
        int low = 1;
        int high = max;
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            int hoursNeeded = getHoursNeeded(piles, mid);
            if(hoursNeeded<=h){
                high = mid-1;
                ans=mid;
            }else{
                low=mid+1;
            }
        }
      return ans;
    }

   int getHoursNeeded(int[] piles, int mid){
       int hours = 0;
       for(int i=0;i<piles.length;i++){
           hours+= (int) Math.ceil((double) piles[i]/(double)mid);
       }
       return hours;
    }


}
