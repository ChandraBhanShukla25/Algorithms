package com.binarysearch;


public class FloorInASortedArray {

    public static void main(String[] args) {
        long[] arr = {1 ,6, 8, 9};
        int N = 4; int x = 4;
        int floor = findFloor(arr, N ,x);
        System.out.println(floor);
    }

    static int findFloor(long arr[], int n, long x) {
        if(arr.length==0){
            return -1;
        }
        int floor = binarySearch(arr, n,0, x);
        return floor;
    }

    private static int binarySearch(long[] arr, int high, int low, long x) {
        int ans = high;
        while(low<=high){
            int mid= (high+low)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;

            }else{
                low= mid+1;
            }
        }
        if(ans==0 && arr[ans]>x){
            return -1;
        }else{
            return ans;
        }
    }
}
