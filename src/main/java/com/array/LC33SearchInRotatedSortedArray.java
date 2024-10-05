package com.array;

public class LC33SearchInRotatedSortedArray {

    public static void main(String[] args) {
       int[] nums = {4,5,6,7,0,1,2};
       int target = 0;
       LC33SearchInRotatedSortedArray searchInRotatedSortedArray = new LC33SearchInRotatedSortedArray();
       int index = searchInRotatedSortedArray.search(nums, target);
       System.out.println(index);
    }

    public int search(int[] nums, int target) {
       int low=0;
       int high = nums.length-1;
       while(low<=high){
           int mid = low+(high-low)/2;

       }
       return 0;
    }
}
