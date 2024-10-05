package com.binarysearch;

public class LC34FirstAndLastPositionOfElements {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,8,10};
        int target = 8;
        LC34FirstAndLastPositionOfElements firstAndLast = new LC34FirstAndLastPositionOfElements();
        int [] arr = firstAndLast.searchRange(nums,target);
        System.out.println(arr[0] + " -- " + arr[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int high = nums.length;
        int low = 0;
        if(nums.length==0){
            return new int[] {-1,-1};
        }
        int first = getFirst(nums,high, low, target);
        int second = getLast(nums, high, low, target);
        return new int[]{first,second};
    }

    private int getLast(int[] nums, int high, int low, int target) {
        int start = low;
        int end = high-1;
        int ans = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                ans=mid;
                start=mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

    private int getFirst(int[] nums, int high, int low, int target) {
        int start = low;
        int end = high-1;
        int ans = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                end = mid-1;
                ans = mid;
            }else if(nums[mid]>target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return ans;
    }




}
