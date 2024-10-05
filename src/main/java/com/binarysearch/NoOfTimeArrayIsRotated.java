package com.binarysearch;

public class NoOfTimeArrayIsRotated {

    public static void main(String[] args) {
      int[] arr = {4, 5, 1, 2, 3};
      int x = noOfTimesArrayIsSorted(arr);
    }

    public  static int noOfTimesArrayIsSorted(int[] arr){
        int low= 0;
        int high = arr.length-1;
        int minIndex = -1;
        int minValue = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=arr[low]){
                if(minValue>arr[low]){
                    minValue = arr[low];
                    minIndex = low;
                }
                low = mid+1;
            }else{
                if(minValue>arr[mid]){
                    minValue = arr[mid];
                    minIndex=mid;
                }
            }
        }
        return 0;
    }
}
