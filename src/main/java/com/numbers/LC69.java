package com.numbers;

public class LC69 {

    public static int mySqrt(int x) {
     int low = 1;
     int high = x;
        int mid=0;
        while(low<=high){
          mid= (low+high)/2;
         int square = mid*mid;
         if(square<=x){
              low = (int)mid+1;
          }else{
             high=(int)mid-1;
          }
     }
     return high;
    }


    public static void main(String[] args) {
        int x = 8;
        int sqrt =  mySqrt(x);
        System.out.println(sqrt);
    }
}
