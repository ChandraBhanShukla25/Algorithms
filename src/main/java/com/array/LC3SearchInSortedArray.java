package com.array;

public class LC3SearchInSortedArray {

    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int target = 0;
        LC3SearchInSortedArray searchInSortedArray = new LC3SearchInSortedArray();
        int index = searchInSortedArray.search(nums, target);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
       return searchInSortedArr(nums, target, 0, nums.length-1);
    }

    private int searchInSortedArr(int[] nums, int target, int low, int high) {
        while(high<=low){
            int mid = low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid+1]==target){
                return mid+1;
            }
            if(nums[mid-1]==target){
                return mid-1;
            }
            if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
