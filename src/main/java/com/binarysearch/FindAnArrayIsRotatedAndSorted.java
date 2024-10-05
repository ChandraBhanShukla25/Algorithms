package com.binarysearch;

public class FindAnArrayIsRotatedAndSorted {

    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        int x = findIndex(arr, 0, arr.length-1);
        System.out.println(x);
    }

    private static int findIndex(int[] arr, int low, int high) {
        int ans= -1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[low]<arr[mid]){
                high= mid-1;
            }else if(arr[high]>arr[mid]){
                low = mid+1;
            }else{
                return mid;
            }
        }
        //System.out.println(mid);
        return -1;
    }
}
