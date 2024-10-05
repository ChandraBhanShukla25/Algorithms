package com.binarysearch;

public class SquareRootBinarySearch {

    public static void main(String[] args) {
        long x=4;
        SquareRootBinarySearch squareRoot = new SquareRootBinarySearch();
        long sqrt = squareRoot.floorSqrt(x);
        System.out.println(sqrt);
    }
    private long floorSqrt(long x)
    {
        long low = 1;
        long high = x;
        if(x<=1){
            return 1;
        }

        while(low<=high){
           long mid = (low+high)/2;
           long val = mid*mid;

           if(val<=x){
               low = mid+1;
           }else{
               high = mid-1;
           }
        }
        return high;
    }

}
