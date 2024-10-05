package com.binarysearch;

public class LC81SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        int target = 0;
        LC81SearchInRotatedSortedArray search = new LC81SearchInRotatedSortedArray();
        System.out.println(search.search(nums,target));
    }

    public boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid= (low+high)/2;

            if(nums[mid]==target){
                return true;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if(nums[low]<=nums[mid]){
               if(nums[low]<=target && target<=nums[mid]){
                   high=mid-1;
               }else{
                   low = mid+1;
               }
            }else{
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }else{
                    high= mid-1;
                }
            }
        }
        return false;
    }
}
