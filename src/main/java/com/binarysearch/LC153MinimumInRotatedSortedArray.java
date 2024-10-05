package com.binarysearch;

public class LC153MinimumInRotatedSortedArray {

    public static void main(String[] args) {
       LC153MinimumInRotatedSortedArray sortedArray = new LC153MinimumInRotatedSortedArray();
       int[] nums = {3,4,5,1,2};
       int minVal = sortedArray.findMin(nums);
        System.out.println(minVal);
    }

    public int findMin(int[] nums) {
       int high = nums.length-1;
       int low = 0;
       int minValue = Integer.MAX_VALUE;
       while(low<=high){
           int mid=(low+high)/2;
           minValue = Integer.min(minValue, mid);
           if(nums[low]<=nums[mid]){
               minValue=Math.min(nums[low],minValue);
               low = mid+1;
           }
           else {
               minValue = Math.min(nums[mid],minValue);
               high=mid-1;
           }
       }
       return minValue;
    }
}
