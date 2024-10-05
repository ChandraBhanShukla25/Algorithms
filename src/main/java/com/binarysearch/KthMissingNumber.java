package com.binarysearch;

public class KthMissingNumber {

    public static void main(String[] args) {
       int[] arr = {2,3,4,7,11};
       int k = 5;
       KthMissingNumber missingNumber = new KthMissingNumber();
       int kthMissing = missingNumber.findKthPositive(arr,k);
        System.out.println(kthMissing);
    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = (low+high)/2;
            int missingNumber = arr[mid]-(mid+1);
            if(missingNumber<k){
                low= mid+1;
            }else{
                high=mid-1;
            }
        }
        return k+high+1;
    }
}
