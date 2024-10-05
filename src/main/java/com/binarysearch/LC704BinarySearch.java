package com.binarysearch;

public class LC704BinarySearch {

    public static void main(String[] args) {
        int[] nums= {-1,0,3,5,9,12};
        int target = 2;
        LC704BinarySearch binarySearch = new LC704BinarySearch();
        int idx = binarySearch.search(nums,target);
        System.out.println(idx);
    }

    public int search(int[] nums, int target) {
       return findSearch(nums, target, 0, nums.length-1);
    }

    private int findSearch(int[] nums, int target, int low, int high) {
        if(high>low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return findSearch(nums, target, low, mid - 1);
            } else {
                return findSearch(nums, target, mid + 1, high);
            }
        } else{
            return -1;
        }
    }
}
