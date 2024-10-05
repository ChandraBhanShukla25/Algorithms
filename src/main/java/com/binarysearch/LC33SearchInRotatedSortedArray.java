package com.binarysearch;

public class LC33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        LC33SearchInRotatedSortedArray search = new LC33SearchInRotatedSortedArray();
        int x= search.search(nums,target);
        System.out.println(x);
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        return searchInSortedArray(nums, start,end,target);
    }

    private int searchInSortedArray(int[] nums, int start, int end, int target) {
        int ans = -1;

        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>=nums[start]){
                if(nums[mid]>=target && nums[start]<=target){
                   end = mid-1;
                }else{
                   start = mid+1;
                }
            }else{
                if(nums[mid]<=target && nums[end]>=target){
                    start = mid+1;
                }else{
                    end= mid-1;
                }
            }
        }
        return -1;
    }
}
