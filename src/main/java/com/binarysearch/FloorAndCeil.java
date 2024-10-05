package com.binarysearch;

public class FloorAndCeil {

    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }

    public static void main(String[] args) {
        int N = 8; int  X = 7;
        int[] Arr = {5, 6, 8, 9, 6, 5, 5, 6};
        FloorAndCeil floorAndCeil = new FloorAndCeil();
        Pair pair = floorAndCeil.getFloorAndCeil(Arr, N, X);
        System.out.println(pair.first + "---"+ pair.second);
    }

    Pair getFloorAndCeil(int[] arr, int n, int x) {
        int first = 0;
        int second = 0;
        int low = 0;
        int high = n-1;
        while(high<=low){
            int mid = (low+high)/2;
            if(arr[mid]<=x){
                second = arr[mid];
                low = mid+1;
            }else{
                first = arr[mid];
                high= mid-1;
            }
        }

        return new Pair(first,second);
    }
}
