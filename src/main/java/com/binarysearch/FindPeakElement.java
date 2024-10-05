package com.binarysearch;

public class FindPeakElement {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        FindPeakElement peakElement = new FindPeakElement();
        int peak = peakElement.findPeakElement(nums);
        System.out.println(peak);
    }

    public int findPeakElement(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }


        int low = 0;
        int high = nums.length-1;


        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                return nums[mid];
            }
            if(nums[mid]>nums[mid-1]){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
